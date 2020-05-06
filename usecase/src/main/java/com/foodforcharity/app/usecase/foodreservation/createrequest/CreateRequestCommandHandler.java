package com.foodforcharity.app.usecase.foodreservation.createrequest;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.*;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.domain.service.RequestService;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand.FoodQuantityPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreateRequestCommandHandler implements CommandHandler<CreateRequestCommand, Response<Void>> {
    private final FoodService foodService;
    private final DonorService donorService;
    private final DoneeService doneeService;
    private final RequestService requestService;

    /**
     * Public Constructor
     *
     * @param foodService
     * @param donorService
     * @param doneeService
     * @param requestService
     */
    @Autowired
    public CreateRequestCommandHandler(FoodService foodService, DonorService donorService, DoneeService doneeService,
                                       RequestService requestService) {
        this.foodService = foodService;
        this.donorService = donorService;
        this.doneeService = doneeService;
        this.requestService = requestService;
    }

    @Override
    public Response<Void> handle(CreateRequestCommand command) {
        try {

            // 1- check if donee exists and has an active status
            Optional<Donee> dbDonee = doneeService.findById(command.doneeId);
            if (dbDonee.isEmpty()) {
                return Response.of(Error.DoneeDoesNotExist);
            }
            Donee donee = dbDonee.get();

            if (donee.getDoneeStatus() != DoneeStatus.Active) {
                return Response.of(Error.IneligibleDoneeStatus);
            }

            // 2-check if donor exists and donee statis is active/inactive
            Optional<Donor> dbDonor = donorService.findById(command.donorId);
            if (dbDonor.isEmpty()) {
                return Response.of(Error.DonorDoesNotExist);
            }
            Donor donor = dbDonor.get();
            if ((donor.getDonorStatus() == DonorStatus.Initial) || (donor.getDonorStatus() == DonorStatus.Suspended)) {
                return Response.of(Error.IneligibleDonorStatus);
            }

            // 3- Validate each food item and add to list of foods
            List<Food> foods = new ArrayList<Food>();

            for (FoodQuantityPair foodQuantityPair : command.foodQuantityPairs) {
                Optional<Food> optionalFood = donor.getFoods().stream().filter(food -> food.getId() == foodQuantityPair.foodId).findFirst();

                if (optionalFood.isEmpty()) {
                    return Response.of(Error.FoodDoesNotExist);
                }

                Food food = optionalFood.get(); // get the food

                // check that quantity requested is valid (>=1)
                Integer minimumQuantity = 1;

                if (foodQuantityPair.quantity < minimumQuantity) {
                    return Response.of(Error.InvalidQuantityRequested);
                }

                // check that food requested is available by the donor
                if (food.getQuantityAvailable() < foodQuantityPair.quantity) {
                    return Response.of(Error.FoodShortage);
                }

                // if food is valid, append it to the list of foods
                foods.add(food);
            }

            // 5- if member_Type is donee check if the quantityrequested is allowed
            if (donee.getDoneeType().equals(DoneeType.Individual)) {
                if (donee.getQuantityRequested() + getTotalQuantityRequested(foods, command.foodQuantityPairs) > donee
                        .getMemberCount()) {
                    return Response.of(Error.QuanityAllowanceExceeded);
                }
            }
            // 6- calculate the total Original price
            Integer finalPrice = getTotalOriginalPrice(foods, command.foodQuantityPairs)
                    * (100 - donor.getDiscountApplied() / 100);

            // 7-create request
            Request request = new Request(); // assuming that id has already been generated
            donor.addRequest(request);
            donee.addRequest(request);
            request.setRequestTime(new Date());
            request.setDiscountApplied((int) donor.getDiscountApplied().doubleValue());
            request.setFinalPrice(finalPrice);
            request.setIsActive(true);
            request.setIsRated(false);

            // 8- create subreqs
            List<SubRequest> subRequests = createSubRequests(request, foods, command.foodQuantityPairs, donor);
            request.setSubRequests(subRequests);

            // 9-update food
            updateAndSaveFoods(foods, command.foodQuantityPairs);

            // // 10-update donee-quantity requested
            donee.setQuantityRequested(
                    donee.getQuantityRequested() + getTotalQuantityRequested(foods, command.foodQuantityPairs));

            // 11- save all repositories
            doneeService.save(donee);
            requestService.save(request);
            // no need to save donor back becasue nothing was changed

            return Response.EmptyResponse();
        } catch (Exception e) {

            return Response.of(Error.UnknownError);
        }
    }

    // converts quantity from integer units to meal units
    private Integer getTotalQuantityRequested(List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
        Integer totalQuantityRequested = 0;
        for (int i = 0; i < foods.size(); i++) {
            Integer quantityRequested = foodQuantityPairs.get(i).quantity;
            Integer mealSize = foods.get(i).getMealForNPeople();
            totalQuantityRequested += quantityRequested * mealSize;
        }
        return totalQuantityRequested;
    }

    private void updateAndSaveFoods(List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
        for (int i = 0; i < foods.size(); i++) {
            // update the food
            Integer quantityAvailaible = foods.get(i).getQuantityAvailable();
            Integer quantityRequested = foodQuantityPairs.get(i).quantity;
            foods.get(i).setQuantityAvailable(quantityAvailaible - quantityRequested);
            // save food
            foodService.save(foods.get(i));
        }

    }

    private List<SubRequest> createSubRequests(Request request, List<Food> foods,
                                               List<FoodQuantityPair> foodQuantityPairs, Donor donor) {
        ArrayList<SubRequest> subRequests = new ArrayList<SubRequest>();
        for (int i = 0; i < foods.size(); i++) {
            SubRequest subRequest = new SubRequest();
            subRequest.setRequest(request);
            subRequest.setFood(foods.get(i));
            subRequest.setQuantity(foodQuantityPairs.get(i).quantity);
            Integer originalPrice = foods.get(i).getPrice();
            Integer Discount = (int) donor.getDiscountApplied().doubleValue();
            Integer price = originalPrice * ((100 - Discount) / 100);
            subRequest.setPriceAtPurchase(price);
            subRequests.add(subRequest);
        }

        return subRequests;

    }

    private Integer getTotalOriginalPrice(List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
        Integer totalOriginalPrice = 0;
        for (int i = 0; i < foods.size(); i++) {
            totalOriginalPrice += foods.get(i).getPrice() * foodQuantityPairs.get(i).quantity;
        }
        return totalOriginalPrice;
    }

}

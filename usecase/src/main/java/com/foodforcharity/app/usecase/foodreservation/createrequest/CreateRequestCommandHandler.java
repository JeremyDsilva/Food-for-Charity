package com.foodforcharity.app.usecase.foodreservation.createrequest;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.entity.SubRequest;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.FoodRepository;
import com.foodforcharity.app.service.RequestRepository;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand.FoodQuantityPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRequestCommandHandler implements CommandHandler<CreateRequestCommand, Response<Void>> {
	private final FoodRepository foodRepository;
	private final DonorRepository donorRepository;
	private final DoneeRepository doneeRepository;
	private final RequestRepository requestRepository;

	// public CreateRequestCommandHandler(){

	// }

	/**
	 * Public Constructor
	 * 
	 * @param foodRepository
	 * @param donorRepository
	 * @param doneeRepository
	 * @param requestRepository
	 */
	@Autowired
	public CreateRequestCommandHandler(FoodRepository foodRepository, DonorRepository donorRepository,
			DoneeRepository doneeRepository, RequestRepository requestRepository) {
		this.foodRepository = foodRepository;
		this.donorRepository = donorRepository;
		this.doneeRepository = doneeRepository;
		this.requestRepository = requestRepository;
	}

	@Override
	public Response<Void> handle(CreateRequestCommand command) {
		Response<Void> response;

		// 1- check if donee exists and has an active status
		response = verifyDoneeExistenceEligibility(command.doneeId);
		if (!response.success()) {
			return response;
		}
		Donee donee = doneeRepository.findById(command.doneeId).get();

		// 2-check if donor exists and donee statis is active/inactive
		response = verifyDonorExistenceEligibility(command.donorId);
		if (!response.success()) {
			return response;
		}
		Donor donor = donorRepository.findById(command.donorId).get();

		// 3- check if food id exists & qty requested is valid, currently available
		response = checkFoodQuantityPairs(command.foodQuantityPairs);
		if (!response.success()) {
			return response;
		}
		List<Food> foods = getAllFoodsFromFoodRepository(command.foodQuantityPairs);

		// 4- verify that all food belong to the donor
		response = matchFoodsDonor(foods, command.donorId);
		if (!response.success()) {
			return response;

		}
		// 5- if member_Type is donee
		// check if the quantityrequested is allowed
		if (donee.getDoneeType() == DoneeType.Individual) {
			response = isQuantityAllowed(donee, foods, command.foodQuantityPairs);

			if (!response.success()) {
				return response;

			}

		}

		// 6- calculate the total Original price
		Integer totalOriginalPrice = getTotalOriginalPrice(foods, command.foodQuantityPairs);
		Integer finalPrice;
		// finalPrice= totalOriginalPrice* ((100-donor.getdiscountApplied())/100);

		// 7-create request
		Request request = new Request(); // assuming that id has already been generated
		request.setDonor(donor);
		request.setDonee(donee);
		request.setRequestTime(new Date());
		// request.setDiscountApplied(donor.getdiscountApplied());
		// request.setFinalPrice(finalPrice);
		// request.setIsActive(true);
		// request.setIsRated(false);

		// 8- create subreqs
		List<SubRequest> subRequests = createSubRequests(request, foods, command.foodQuantityPairs, donor);
		request.setSubRequests(subRequests);

		// 9-update food
		updateAndSaveFoods(foods, command.foodQuantityPairs);

		// 10-update donee-quantity requested
		Integer oldQuantityRequested = donee.getQuantityRequested();
		Integer newQuantityRequested = getTotalQuantityRequested(foods, command.foodQuantityPairs);
		donee.setQuantityRequested(oldQuantityRequested + newQuantityRequested);

		// 11- save all repositories
		doneeRepository.save(donee);
		requestRepository.save(request);
		// no need to save donor back becasue nothing was changed

		return Response.EmptyResponse();

	}

	private Response<Void> isQuantityAllowed(Donee donee, List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
		Integer memberCount = donee.getMemberCount();
		Integer oldQuantityRequested = donee.getQuantityRequested();
		Integer newQuantityRequested = getTotalQuantityRequested(foods, foodQuantityPairs);

		// if they have already completed their quota or if they are asking for more
		// than what they can
		if (oldQuantityRequested == memberCount || (oldQuantityRequested + newQuantityRequested) > memberCount) {
			return new Response<Void>(Error.QuanityAllowanceExceeded);
		}

		return Response.EmptyResponse();
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

	private Response<Void> matchFoodsDonor(List<Food> foods, long donorId) {
		for (Food food : foods) {
			if (food.getDonor().getId() != donorId) {// i donot know how to macth objects
				return new Response<Void>(Error.FoodsDonorMismatch);
			}

		}
		return Response.EmptyResponse();
	}

	private Response<Void> verifyDonorExistenceEligibility(long donorId) {
		Optional<Donor> dbDonor = donorRepository.findById(donorId);
		if (dbDonor.isEmpty()) {
			return new Response<Void>(Error.DonorDoesNotExist);
		}
		Donor donor = dbDonor.get();
		if (donor.getDonorStatus() != DonorStatus.Active || donor.getDonorStatus() != DonorStatus.Inactive) {
			return new Response<Void>(Error.IneligibleDonorStatus);
		}
		return Response.EmptyResponse();

	}

	private Response<Void> verifyDoneeExistenceEligibility(long doneeId) {
		Optional<Donee> dbDonee = doneeRepository.findById(doneeId);
		if (dbDonee.isEmpty()) {
			return new Response<Void>(Error.DoneeDoesNotExist);
		}
		Donee donee = dbDonee.get();
		if (donee.getDoneeStatus() != DoneeStatus.Active) {
			return new Response<Void>(Error.IneligibleDoneeStatus);
		}
		return Response.EmptyResponse();
	}

	private void updateAndSaveFoods(List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
		for (int i = 0; i < foods.size(); i++) {
			// update the food
			Integer quantityAvailaible = foods.get(i).getQuantityAvailable();
			Integer quantityRequested = foodQuantityPairs.get(i).quantity;
			foods.get(i).setQuantityAvailable(quantityAvailaible - quantityRequested);
			// save food
			foodRepository.save(foods.get(i));
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
			// Integer originalPrice=foods.get(i).getPrice();
			// Integer Discount= donor.getDiscountApplied();
			// Integer price = originalPrice* ((100-Discount)/100);
			// subRequest.setPriceAtPurchase(price);
			subRequests.add(subRequest);
		}

		return subRequests;

	}

	private Integer getTotalOriginalPrice(List<Food> foods, List<FoodQuantityPair> foodQuantityPairs) {
		Integer totalOriginalPrice = 0;
		for (int i = 0; i < foods.size(); i++) {
			// since the lists are ordered no need to check if the ids match
			Integer price = foods.get(i).getPrice();
			Integer quantity = foodQuantityPairs.get(i).quantity;
			totalOriginalPrice += price * quantity;
		}

		return totalOriginalPrice;
	}

	private List<Food> getAllFoodsFromFoodRepository(List<FoodQuantityPair> foodQuantityPairs) {
		ArrayList<Food> foods = new ArrayList<Food>();
		for (FoodQuantityPair foodQuantityPair : foodQuantityPairs) {
			Food food = foodRepository.findById(foodQuantityPair.foodId).get();
			foods.add(food);
		}
		return foods;
	}

	// check if food exists and quantiy is valid and available
	private Response<Void> checkFoodQuantityPairs(List<FoodQuantityPair> foodQuantityPairs) {
		for (FoodQuantityPair foodQuantityPair : foodQuantityPairs) {
			Optional<Food> dbFood = foodRepository.findById(foodQuantityPair.foodId);
			if (dbFood.isEmpty()) {
				return new Response<Void>(Error.FoodDoesNotExist);
			}

			Food food = dbFood.get();
			Integer quantity = foodQuantityPair.quantity;
			Integer minimumQuantity = 1;

			if (quantity < minimumQuantity) {
				return new Response<Void>(Error.InvalidQuantityRequested);
			}

			if (food.getQuantityAvailable() < quantity) {
				return new Response<Void>(Error.FoodShortage); // i want to create a more specific error whihc includes
																// food name
			}
		}
		return Response.EmptyResponse();
	}

}
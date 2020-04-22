package com.foodforcharity.app.usecase.foodreservation;

import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.*;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.domain.service.RequestService;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.foodreservation.requestcompletion.RequestCompletionCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestCompletionTest {

    @Autowired
    CommandHandler<RequestCompletionCommand, Response<Void>> handler;

    @Autowired
    FoodService foodRepos;

    @Autowired
    DonorService donorRepos;

    @Autowired
    DoneeService doneeRepos;

    @Autowired
    RequestService requestRepos;

    Donor donor;
    Food food;
    Donee donee;
    Request request;

    @Before
    public void init() {

        Optional<Request> dbRequest = requestRepos.findById(Long.valueOf(1));
        if (dbRequest.isPresent()) {
            request = dbRequest.get();
            donor = request.getDonor();
            request.setIsActive(true);
            requestRepos.save(request);
        } else {
            Optional<Food> dbFood = foodRepos.findById(Long.valueOf(1));

            if (dbFood.isPresent()) {
                food = dbFood.get();
                food.setMealForNPeople(1);
                donor = food.getDonor();
                donor.setDonorStatus(DonorStatus.Active);
                // foodRepos.save(food);
                donorRepos.save(donor);

            } else {

                Optional<Donor> dbDonor = donorRepos.findByUsername("donoremail@gmail.com");
                if (dbDonor.isEmpty()) {
                    donor = new Donor();
                    donor.setAddressDescription("DonorAddressDescription");
                    donor.setCity("DonorCity");
                    donor.setCountry("DonorCountry");
                    donor.setDonorName("DonorName");
                    donor.setEmail("donoremail@gmail.com");
                    donor.setNumberOfRating(0);
                    donor.setPassword("DonorPassword");
                    donor.setPhoneNumber("DonorPhoneNumber");
                    donor.setRating(0);
                    donor.setDiscountApplied(10);
                    donor.setUsername(donor.getEmail());
                    donorRepos.save(donor);
                } else {
                    donor = dbDonor.get();
                    donor.setDonorStatus(DonorStatus.Active);
                    donorRepos.save(donor);
                }

                food = new Food();
                food.setFoodName("foodName");
                food.setDescriptionText("descriptionText");
                food.setCuisine(Cuisine.Belgravian);
                food.setMealType(MealType.Mixed);
                food.setPrice(200);
                food.setQuantityAvailable(23);
                food.setMealForNPeople(1);
                food.setSpiceLevel(SpiceLevel.MildSpice);

                // food.setMealTypes(MealType.RedMeat);
                List<Allergen> aList = Arrays.asList(Allergen.Dairy);
                Set<Allergen> iSet = new HashSet<Allergen>(aList);

                food.setAllergens(iSet);
                // foodRepos.save(food);
                donor.addFood(food);
                donor = donorRepos.save(donor);
            }

            Optional<Donee> dbDonee = doneeRepos.findByUsername("doneeemail@gmail.com");

            if (dbDonee.isPresent()) {
                donee = dbDonee.get();
                donee.setDoneeStatus(DoneeStatus.Active);
                donee.setQuantityRequested(0);
                donee.setMemberCount(food.getMealForNPeople() + 2); // so that quantity is never exceded if we ask for 1
                doneeRepos.save(donee);
            } else {

                donee = new Donee();
                donee.setAddressDescription("DoneeAddressDescription");
                donee.setCity("DoneeCity");
                donee.setCountry("DoneeCountry");
                donee.setDoneeName("DoneeName");
                donee.setDoneeStatus(DoneeStatus.Active);
                donee.setEmail("doneeemail@gmail.com");
                donee.setDoneeType(DoneeType.Individual);
                donee.setPassword("DoneePassword");
                donee.setPhoneNumber("DoneePhoneNumber");
                donee.setMemberCount(food.getMealForNPeople() + 2);
                donee.setQuantityRequested(0);
                donee.setUsername(donee.getEmail());
                donee = doneeRepos.save(donee);
            }

            // create a new request = request id is auto generated
            // setting manually because need a request id
            SubRequest subR = new SubRequest();
            subR.setFood(food);
            subR.setQuantity(1);

            Request request = new Request();
            request.addSubRequest(subR);
            request.setDiscountApplied(donor.getDiscountApplied());
            request.setDonee(donee);
            request.setDonor(donor);
            request.setFinalPrice(food.getPrice() * (100 - donor.getDiscountApplied() / 100));
            request.setIsActive(true);
            request.setRequestTime(new Date());
            subR.setRequest(request);
            request = requestRepos.save(request);
        }
    }

    @Test
    public void successTest() {

        RequestCompletionCommand command = new RequestCompletionCommand(donor.getId(), request.getId());

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

}
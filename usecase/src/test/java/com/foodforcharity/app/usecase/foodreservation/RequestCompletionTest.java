package com.foodforcharity.app.usecase.foodreservation;

import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.*;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.domain.service.RequestService;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.FoodRepository;
import com.foodforcharity.app.infrastructure.repository.RequestRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.foodreservation.requestcompletion.RequestCompletionCommand;
import com.foodforcharity.app.usecase.foodreservation.requestcompletion.RequestCompletionCommandHandler;

import org.junit.After;
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
    FoodRepository foodRepos;

    @Autowired
    DonorRepository donorRepos;

    @Autowired
    DoneeRepository doneeRepos;

    @Autowired
    RequestRepository requestRepos;

    Donor donor,donor2;
    Food food,food2;
    Donee donee;
    Request request;
   

    @Before
    public void init() {

        donor = new Donor();
       donor2= new Donor();
    
        donor.setAddressDescription("DonorAddressDescription");
       donor2.setAddressDescription("Donor2AddressDescription");

        donor.setCity("DonorCity");
       donor2.setCity("Donor2City");

        donor.setCountry("DonorCountry");
       donor2.setCountry("Donor2Country");

        donor.setDonorName("DonorName");
       donor2.setDonorName("donor2Name");

        donor.setEmail("donoremail@gmail.com");
       donor2.setEmail("donor2email@gmail.com");

        donor.setNumberOfRating(0);
       donor2.setNumberOfRating(0);

        donor.setPassword("DonorPassword");
       donor2.setPassword("Donor2Password");

        donor.setPhoneNumber("DonorPhoneNumber");
        donor2.setPhoneNumber("Donor2PhoneNumber");

        donor.setRating(0);
       donor2.setRating(0);

        donor.setDiscountApplied(10);
        donor2.setDiscountApplied(10);

        donor.setUsername(donor.getEmail());
        donor2.setUsername(donor2.getEmail());

        donor.setDonorStatus(DonorStatus.Active);
        donor2.setDonorStatus(DonorStatus.Active);
        


        food = new Food();
        food2= new Food();
        food.setFoodName("foodName");
        food.setDescriptionText("descriptionText");
        food.setCuisine(Cuisine.Belgravian);
        food.setMealType(MealType.Mixed);
        food.setPrice(200);
        food.setQuantityAvailable(23);
        food.setMealForNPeople(1);
        food.setSpiceLevel(SpiceLevel.MildSpice);
        food.setAllergens(new HashSet<Allergen>(Arrays.asList(Allergen.Dairy)));

        food2.setFoodName("food2Name");
        food2.setDescriptionText("description2Text");
        food2.setCuisine(Cuisine.Chinese);
        food2.setMealType(MealType.RedMeat);
        food2.setPrice(250);
        food2.setQuantityAvailable(45);
        food2.setMealForNPeople(1);
        food2.setSpiceLevel(SpiceLevel.ExtraHot);
        food2.setAllergens(new HashSet<Allergen>(Arrays.asList(Allergen.Nuts)));

        donor.addFood(food);
        donor2.addFood(food2);


        donor = donorRepos.save(donor);
       donor2 = donorRepos.save(donor2);

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
        // create a new request = request id is auto generated
        // setting manually because need a request id
        SubRequest subR = new SubRequest();
        subR.setFood(food);
        subR.setQuantity(1);
        subR.setPriceAtPurchase(food.getPrice() * (100 - donor.getDiscountApplied() / 100));

        request = new Request();
        donor.addRequest(request);
        donee.addRequest(request);
        donee.addRequest(request);
        request.addSubRequest(subR);
        request.setDiscountApplied(donor.getDiscountApplied());
        request.setFinalPrice(food.getPrice() * (100 - donor.getDiscountApplied() / 100));
        request.setIsActive(true);
        request.setIsRated(false);
        request.setRequestTime(new Date());
        request = requestRepos.save(request);
       
        
       

    }

    @After
    public void destroy() {
        donor = ((DonorService) donorRepos).findById(donor.getId()).get();
        donor2 = ((DonorService) donorRepos).findById(donor2.getId()).get();
        if (donor.getRequests() != null)
            requestRepos.deleteAll(donor.getRequests());
        if (donor2.getRequests() != null)
            requestRepos.deleteAll(donor.getRequests());
        foodRepos.deleteById(food.getId());
        foodRepos.deleteById(food2.getId());
        donorRepos.deleteById(donor.getId());
        donorRepos.deleteById(donor2.getId());
        doneeRepos.deleteById(donee.getId());
    }

    @Test
    public void successTest() {

        RequestCompletionCommand command = new RequestCompletionCommand(donor.getId(), request.getId());

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void RequestDoesNotExistTest() {

        RequestCompletionCommand command = new RequestCompletionCommand(donor.getId(), 500);

        Response<Void> response = handler.handle(command);
        assert (response.getError() == Error.RequestDoesNotExist);

    }

    @Test
    public void InactiveRequestTest() {
       
        request.setIsActive(false);
        requestRepos.save(request);

        RequestCompletionCommand command = new RequestCompletionCommand(donor.getId(), request.getId());

        Response<Void> response = handler.handle(command);
        assert (response.getError() == Error.InactiveRequest);

       

    }

    @Test
    public void DonorRequestDontMatchTest() {
       
        requestRepos.save(request);

        RequestCompletionCommand command = new RequestCompletionCommand(donor2.getId(), request.getId());

        Response<Void> response = handler.handle(command);
        assert (response.getError() == Error.DonorRequestDontMatch);

       

    }





}
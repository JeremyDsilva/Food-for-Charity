package com.foodforcharity.app.usecase.profile;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.FoodRepository;
import com.foodforcharity.app.infrastructure.repository.RequestRepository;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.profile.deletemenuitem.DeleteMenuItemCommand;

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
public class DeleteMenuTest {

    @Autowired
    CommandHandler<DeleteMenuItemCommand, Response<Void>> handler;

    @Autowired
    FoodRepository foodRepos;

    @Autowired
    DonorRepository donorRepos;

    @Autowired
    DoneeRepository doneeRepos;

    @Autowired
    RequestRepository requestRepos;

    Donor donor;
    Food food;
    Donee donee;
    Request request;

    @Before
    public void init() {

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
        

        donor.setDonorStatus(DonorStatus.Active);
        

        food = new Food();
        
        food.setFoodName("foodName");
        food.setDescriptionText("descriptionText");
        food.setCuisine(Cuisine.Belgravian);
        food.setMealType(MealType.Mixed);
        food.setPrice(200);
        food.setQuantityAvailable(23);
        food.setMealForNPeople(1);
        food.setSpiceLevel(SpiceLevel.MildSpice);
        food.setAllergens(new HashSet<Allergen>(Arrays.asList(Allergen.Dairy)));

       

        donor.addFood(food);
       

        donor = donorRepos.save(donor);
       
        // donee = new Donee();
        // donee.setAddressDescription("DoneeAddressDescription");
        // donee.setCity("DoneeCity");
        // donee.setCountry("DoneeCountry");
        // donee.setDoneeName("DoneeName");
        // donee.setDoneeStatus(DoneeStatus.Active);
        // donee.setEmail("doneeemail@gmail.com");
        // donee.setDoneeType(DoneeType.Individual);
        // donee.setPassword("DoneePassword");
        // donee.setPhoneNumber("DoneePhoneNumber");
        // donee.setMemberCount(food.getMealForNPeople() + 2);
        // donee.setQuantityRequested(0);
        // donee.setUsername(donee.getEmail());
        // donee = doneeRepos.save(donee);
        // // create a new request = request id is auto generated
        // // setting manually because need a request id
        // SubRequest subR = new SubRequest();
        // subR.setFood(food);
        // subR.setQuantity(1);
        // subR.setPriceAtPurchase(food.getPrice() * (100 - donor.getDiscountApplied() / 100));

        // request = new Request();
        // donor.addRequest(request);
        // donee.addRequest(request);
        // donee.addRequest(request);
        // request.addSubRequest(subR);
        // request.setDiscountApplied(donor.getDiscountApplied());
        // request.setFinalPrice(food.getPrice() * (100 - donor.getDiscountApplied() / 100));
        // request.setIsActive(true);
        // request.setIsRated(false);
        // request.setRequestTime(new Date());
        // request = requestRepos.save(request);

    }

    @After
    public void destroy() {
        donor = ((DonorService) donorRepos).findById(donor.getId()).get();

        // if (donor.getRequests() != null)
        //     requestRepos.deleteAll(donor.getRequests());

    //    if (donor.getFoods() != null)
            foodRepos.deleteAll();
        
        

        donorRepos.deleteById(donor.getId());

    
    }

    @Test
    public void successTest() {

        // request.setIsActive(false);
        // requestRepos.save(request);
        DeleteMenuItemCommand command = new DeleteMenuItemCommand(donor.getId(), food.getId());

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void foodDoesNotExistTest() {
        assert (handler.handle(new DeleteMenuItemCommand(donor.getId(), Long.valueOf(100)))
                .getError() == Error.FoodDoesNotExist);
    }

    @Test
    public void foodsDonorMismatchTest() {
        assert (handler.handle(new DeleteMenuItemCommand(Long.valueOf(100), food.getId()))
                .getError() == Error.FoodsDonorMismatch);
    }



    // @Test
    public void FoodHasActiveRequestOrComplaintsTest() {
        assert (handler.handle(new DeleteMenuItemCommand(Long.valueOf(100), food.getId()))
                .getError() == Error.FoodHasActiveRequestOrComplaints);
    }

}
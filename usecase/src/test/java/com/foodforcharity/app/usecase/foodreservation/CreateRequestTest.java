package com.foodforcharity.app.usecase.foodreservation;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.FoodRepository;
import com.foodforcharity.app.infrastructure.repository.RequestRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateRequestTest {

    @Autowired
    CommandHandler<CreateRequestCommand, Response<Void>> handler;

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

    @After
    public void destroy() {
        donor = ((DonorService) donorRepos).findById(donor.getId()).get();
        if (donor.getRequests() != null)
            requestRepos.deleteAll(donor.getRequests());
        foodRepos.deleteById(food.getId());
        donorRepos.deleteById(donor.getId());
        doneeRepos.deleteById(donee.getId());
    }

    @Test
    public void successTest() {
        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 1);

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void DoneeDoesNotExistTest() {

        CreateRequestCommand command = new CreateRequestCommand(Long.valueOf(1000), donor.getId());
        command.addFood(food.getId(), 1);

        assert (handler.handle(command).getError() == Error.DoneeDoesNotExist);
    }

    @Test
    public void DonorDoesNotExistTest() {

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), Long.valueOf(1000));
        command.addFood(food.getId(), 1);

        assert (handler.handle(command).getError() == Error.DonorDoesNotExist);
    }

    @Test
    public void IneligibleDonorStatusTest() {
        DonorStatus donorStatusToRemember = donor.getDonorStatus(); // save it for later

        donor.setDonorStatus(DonorStatus.Initial);
      donor= donorRepos.save(donor);

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 1);
        Response<Void> response = handler.handle(command);

        donor.setDonorStatus(DonorStatus.Suspended);
        donorRepos.save(donor);
        //////////////////// simple decision 2//////////////

        CreateRequestCommand commandSuspended = new CreateRequestCommand(donee.getId(), donor.getId());
        commandSuspended.addFood(food.getId(), 1);
        Response<Void> responseSuspended = handler.handle(commandSuspended);

        assert (responseSuspended.getError() == Error.IneligibleDonorStatus
                && response.getError() == Error.IneligibleDonorStatus);
    }

    @Test
    public void IneligibleDoneeStatusTest() {
        DoneeStatus doneeStatusToRemember = donee.getDoneeStatus(); // save it for later

        donee.setDoneeStatus(DoneeStatus.Initial);
        doneeRepos.save(donee);

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 1);
        Response<Void> responseInitial = handler.handle(command);

        donee.setDoneeStatus(DoneeStatus.Suspended);
        doneeRepos.save(donee);
        //////////////////// simple decision 2//////////////
        CreateRequestCommand commandSuspended = new CreateRequestCommand(donee.getId(), donor.getId());
        commandSuspended.addFood(food.getId(), 1);
        Response<Void> responseSuspended = handler.handle(commandSuspended);

        assert (responseSuspended.getError() == Error.IneligibleDoneeStatus
                && responseInitial.getError() == Error.IneligibleDoneeStatus);
    }

    @Test
    public void FoodDoesNotExistTest() {

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(100, 1);

        assert (handler.handle(command).getError() == Error.FoodDoesNotExist);
    }


    @Test
    public void InvalidQuantityRequested() {

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 0);

        assert (handler.handle(command).getError() == Error.InvalidQuantityRequested);
    }


    @Test
    public void QuantityAllowanceExceededTest() {
        DoneeType doneeTypeToRemember = donee.getDoneeType(); // save it for later
        Integer initialQuantityRequested = donee.getQuantityRequested();
        Integer initialFoodQuantityAvailable = food.getQuantityAvailable();

        donee.setDoneeType(DoneeType.Individual);
        donee.setQuantityRequested(donee.getMemberCount());
       donee= doneeRepos.save(donee);

        Integer quantityToRequest = 1;
        CreateRequestCommand command1 = new CreateRequestCommand(donee.getId(), donor.getId());
        command1.addFood(food.getId(), quantityToRequest);
        Response<Void> response1 = handler.handle(command1);

        //////////////////// simple decision 2//////////////

        donee.setDoneeType(DoneeType.Individual);
        donee.setQuantityRequested(initialQuantityRequested);
        doneeRepos.save(donee);

        food.setQuantityAvailable(initialQuantityRequested + 100);
        foodRepos.save(food);

        CreateRequestCommand command2 = new CreateRequestCommand(donee.getId(), donor.getId());
        command2.addFood(food.getId(), food.getQuantityAvailable()); // maximum that they can asknwithout getting food
        // shortage error
        Response<Void> response2 = handler.handle(command2);

        assert (response1.getError() == Error.QuanityAllowanceExceeded
                && response2.getError() == Error.QuanityAllowanceExceeded);
    }


    // while loop test
}
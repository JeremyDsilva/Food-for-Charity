package com.foodforcharity.app.usecase.foodreservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.FoodRepository;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand.FoodQuantityPair;
import com.foodforcharity.app.usecase.profile.addmenu.AddMenuCommand;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    Donor donor;

    Food food;
    Donee donee;

    @Before
    public void init() {

        Optional<Food> dbFood = foodRepos.findById(Long.valueOf(1));

        if (dbFood.isPresent()) {
            food = dbFood.get();
            donor = food.getDonor();
        } else {

            Optional<Donor> dbDonor = donorRepos.findById(Long.valueOf(1));
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
                donor.setUsername(donor.getEmail());
            } else {
                donor = dbDonor.get();
            }

            donor.setDonorStatus(DonorStatus.Active);

            //
            food = new Food();
            food.setFoodName("foodName");
            food.setDescriptionText("descriptionText");
            food.setCuisines(Cuisine.Belgravian);
            food.setMealType(MealType.Mixed);
            food.setPrice(200);
            food.setQuantityAvailable(23);
            food.setMealForNPeople(3);
            food.setSpiceLevel(SpiceLevel.MildSpice);

            // food.setMealTypes(MealType.RedMeat);
            List<Allergen> aList = Arrays.asList(Allergen.Dairy);
            Set<Allergen> iSet = new HashSet<Allergen>(aList);

            food.setAllergens(iSet);

            donor.addFood(food);
            donor = donorRepos.save(donor);
        }

        Optional<Donee> dbDonee = doneeRepos.findById(Long.valueOf(6));

        Donee donee;
        if (dbDonee.isPresent()) {
            donee = dbDonee.get();

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
            donee.setMemberCount(2);
            donee.setQuantityRequested(0);
            donee.setUsername(donee.getEmail());
            donee = doneeRepos.save(donee);
        }

    }

    // @Test
    public void successTest() {

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 1);

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

}
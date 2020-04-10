package com.foodforcharity.app.usecase.foodreservation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;
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
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand;

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
    FoodService foodRepos;

    @Autowired
    DonorService donorRepos;

    @Autowired
    DoneeService doneeRepos;

    Donor donor;
    Food food;
    Donee donee;

    @Before
    public void init() {

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
            food.setCuisines(Cuisine.Belgravian);
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
            donee.setMemberCount(food.getMealForNPeople()+2); // so that quantity is never exceded if we ask for 1
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
            donee.setMemberCount(food.getMealForNPeople()+2);
            donee.setQuantityRequested(0);
            donee.setUsername(donee.getEmail());
            donee = doneeRepos.save(donee);
        }

    }

    // @Test
    // public void test() {
    // }

    @Test
    public void successTest() {

        CreateRequestCommand command = new CreateRequestCommand(donee.getId(), donor.getId());
        command.addFood(food.getId(), 1);

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

}
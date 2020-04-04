package com.foodforcharity.app.usecase.profile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.FoodRepository;
import com.foodforcharity.app.usecase.profile.modifymenuitem.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModifyMenuTest {

    @Autowired
    CommandHandler<ModifyMenuItemCommand, Response<Void>> handler;

    @Autowired
    FoodRepository foodRepos;

    @Autowired
    DonorRepository repos;

    Donor donor;
    Food food;

    @Before
    public void init() {

        Optional<Food> dbFood = foodRepos.findById(Long.valueOf(1));

        if (dbFood.isPresent())
            food = dbFood.get();
        else {

            donor = new Donor();
            donor.setAddressDescription("DonorAddressDescription");
            donor.setCity("DonorCity");
            donor.setCountry("DonorCountry");
            donor.setDonorName("DonorName");
            donor.setDonorStatus(DonorStatus.Initial);
            donor.setEmail("donoremail@gmail.com");
            donor.setNumberOfRating(0);
            donor.setPassword("DonorPassword");
            donor.setPhoneNumber("DonorPhoneNumber");
            donor.setRating(0);
            donor.setUsername(donor.getEmail());

            //
            food = new Food();
            food.setFoodName("foodName");
            food.setDescriptionText("descriptionText");
            food.setCuisines(Cuisine.Belgravian);
            food.setPrice(200);
            food.setQuantityAvailable(23);
            food.setMealForNPeople(3);
            food.setSpiceLevel(SpiceLevel.MildSpice);
            
            // food.setMealTypes(MealType.RedMeat);
            List<Allergen> aList = Arrays.asList(Allergen.Dairy);
            Set<Allergen> iSet = new HashSet<Allergen>(aList);

            food.setAllergens(iSet);

            donor.addFood(food);
            donor = repos.save(donor);
        }
    }

    List<Allergen> aList = Arrays.asList(Allergen.Nuts);
    Set<Allergen> hSet = new HashSet<Allergen>(aList);

    @Test
    public void successTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setMealType(MealType.Seafood);
        Response<Void> response = handler.handle(command);
        assert (response.success());
    }


    @Test
    public void InvalidFoodNameTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setFoodName(" ");
        assert (handler.handle(command).getError() == Error.InvalidFoodName);
    }

    @Test
    public void InvalidFoodDescriptionTextTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setDescriptionText(" ");
        assert (handler.handle(command).getError() == Error.InvalidFoodDescriptionText);
    }

    @Test
    public void InvalidOriginalPriceTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setPrice(-23);
        assert (handler.handle(command).getError() == Error.InvalidOriginalPrice);
    }

    @Test
    public void InvalidMealSizeTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setMealForNPeople(0);
        Error error = handler.handle(command).getError();
        assert (error == Error.InvalidMealSize);

    }

    @Test
    public void InvalidQuantityAvailableTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), food.getId());
        command.setQuantityAvailable(-2);
        assert (handler.handle(command).getError() == Error.InvalidQuantityAvailable);
    }

    @Test
    public void FoodDoesNotExistTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(donor.getId(), 100);
        assert (handler.handle(command).getError() == Error.FoodDoesNotExist);
    }
    @Test
    public void FoodsDonorMismatchTest() {
        ModifyMenuItemCommand command = new ModifyMenuItemCommand( 100,food.getId());
        assert (handler.handle(command).getError() == Error.FoodsDonorMismatch);
    }

}
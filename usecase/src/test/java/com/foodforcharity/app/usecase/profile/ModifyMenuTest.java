package com.foodforcharity.app.usecase.profile;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.FoodRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.profile.modifymenuitem.ModifyMenuItemCommand;

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
public class ModifyMenuTest {

    @Autowired
    CommandHandler<ModifyMenuItemCommand, Response<Void>> handler;

    @Autowired
    FoodRepository foodRepos;

    @Autowired
    DonorRepository donorRepos;

    Donor donor;
    Food food;

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
    }
    @After
    public void destroy() {
        donor = ((DonorService) donorRepos).findById(donor.getId()).get();
        
        foodRepos.deleteById(food.getId());
        donorRepos.deleteById(donor.getId());
       
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
        ModifyMenuItemCommand command = new ModifyMenuItemCommand(100, food.getId());
        assert (handler.handle(command).getError() == Error.FoodsDonorMismatch);
    }

}
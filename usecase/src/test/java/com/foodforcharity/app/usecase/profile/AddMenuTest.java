package com.foodforcharity.app.usecase.profile;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.FoodRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.profile.addmenu.AddMenuCommand;

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
public class AddMenuTest {

    @Autowired
    CommandHandler<AddMenuCommand, Response<Void>> handler;

    @Autowired
    DonorRepository donorRepos;

    @Autowired
    FoodRepository foodRepos;

    Donor donor;

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
        donor = donorRepos.save(donor);

    }

    @After
    public void destroy() {
        donor = ((DonorService) donorRepos).findById(donor.getId()).get();
        if (donor.getFoods() != null)
            foodRepos.deleteAll(donor.getFoods());
        donorRepos.deleteById(donor.getId());

    }

    List<Allergen> aList = Arrays.asList(Allergen.Dairy);
    Set<Allergen> hSet = new HashSet<Allergen>(aList);

    @Test
    public void successTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName", "descriptionText", 500, 20, 50,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void InvalidFoodNameTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), " ", "descriptionText", 500, 20, 50,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.InvalidFoodName);
    }

    @Test
    public void InvalidFoodDescriptionTextTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName", " ", 500, 20, 50, SpiceLevel.ExtraHot,
                MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.InvalidFoodDescriptionText);
    }

    @Test
    public void InvalidOriginalPriceTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText", -2, 20, 50,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.InvalidOriginalPrice);
    }

    @Test
    public void InvalidMealSizeTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText", 500, 0, 50,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.InvalidMealSize);
    }

    @Test
    public void InvalidQuantityAvailableTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText", 500, 20, -3,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.InvalidQuantityAvailable);
    }

    @Test
    public void DoneeDoesNotExistTest() {
        AddMenuCommand command = new AddMenuCommand(100, "foodName ", "descriptionText", 500, 20, 50,
                SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese, hSet);
        assert (handler.handle(command).getError() == Error.DonorDoesNotExist);
    }

}
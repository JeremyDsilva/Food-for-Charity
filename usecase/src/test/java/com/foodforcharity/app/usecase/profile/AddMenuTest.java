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
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.usecase.profile.addmenu.AddMenuCommand;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddMenuTest {

    @Autowired
    CommandHandler<AddMenuCommand, Response<Void>> handler;

    @Autowired
    DonorRepository repos;

    Donor donor;
    
    @Before
    public void init() {

        Optional<Donor> dbDonor = repos.findById(Long.valueOf(1));

        if (dbDonor.isPresent())
            donor = dbDonor.get();
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

            donor = repos.save(donor);
        }
    }
    List<Allergen> aList= Arrays.asList(Allergen.Dairy);
    Set<Allergen> hSet = new HashSet<Allergen>(aList);
    
    
    

    @Test
    public void successTest() {
       AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName", "descriptionText",500, 20,
    50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void InvalidFoodNameTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), " ", "descriptionText",500, 20,
        50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.InvalidFoodName);
    }

    @Test
    public void InvalidFoodDescriptionTextTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName", " ",500, 20,
        50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.InvalidFoodDescriptionText);
    }


    @Test
    public void InvalidOriginalPriceTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText",-2, 20,
        50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.InvalidOriginalPrice);
    }


    @Test
    public void InvalidMealSizeTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText",500, 0,
        50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.InvalidMealSize);
    }

    @Test
    public void InvalidQuantityAvailableTest() {
        AddMenuCommand command = new AddMenuCommand(donor.getId(), "foodName ", "descriptionText",500, 20,
        -3, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.InvalidQuantityAvailable);
    }

    @Test
    public void DoneeDoesNotExistTest() {
        AddMenuCommand command = new AddMenuCommand(100, "foodName ", "descriptionText",500, 20,
        50, SpiceLevel.ExtraHot, MealType.Chicken, Cuisine.Chinese,hSet);
        assert (handler.handle(command).getError() == Error.DoneeDoesNotExist);
    }


    

}
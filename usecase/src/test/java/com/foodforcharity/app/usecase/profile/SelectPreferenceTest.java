package com.foodforcharity.app.usecase.profile;

import java.util.ArrayList;
import java.util.List;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.DoneePriceRange;
import com.foodforcharity.app.domain.entity.DoneeSpiceRange;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

 @RunWith(SpringRunner.class)
 @SpringBootTest
public class SelectPreferenceTest {

    @Autowired
    CommandHandler<SelectPreferencesCommand, Response<Void>> handler;

    @Autowired
    DoneeRepository doneeRepos;

    Donee donee;

    @Before
    public void init() {

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
        donee.setMemberCount(5);
        donee.setQuantityRequested(0);
        donee.setUsername(donee.getEmail());
        donee.setPriceRange(new DoneePriceRange());;
        donee.getPriceRange().setStartPrice(0);
        donee.getPriceRange().setEndPrice(10);
        donee = doneeRepos.save(donee);
    }

    @After
    public void destroy() {
        doneeRepos.deleteById(donee.getId());
    }

     @Test
    public void SuccessTest() {

        SelectPreferencesCommand command = new SelectPreferencesCommand();

        Range<SpiceLevel> spiceRange = command.new Range<SpiceLevel>(SpiceLevel.NoSpice, SpiceLevel.ExtraHot);
        List<Allergen> allergens = new ArrayList<Allergen>();
        allergens.add(Allergen.Dairy);
        allergens.add(Allergen.Nuts);
        Range<Integer> priceRange = command.new Range<Integer>(0, 25);
        List<Cuisine> cuisines = new ArrayList<Cuisine>();
        cuisines.add(Cuisine.NoPreference);
        List<MealType> mealTypes = new ArrayList<MealType>();
        mealTypes.add(MealType.Chicken);

        command.setDoneeId(donee.getId());

        command.setSpiceRange(spiceRange);
        command.setPriceRange(priceRange);

        command.setAllergens(allergens);
        command.setMealTypes(mealTypes);
        command.setCuisines(cuisines);

        Response<Void> response = handler.handle(command);
        assert (response.success());
    }


    @Test
    public void DoneeDoesNotExistTest(){
        SelectPreferencesCommand command = new SelectPreferencesCommand();

        Range<SpiceLevel> spiceRange = command.new Range<SpiceLevel>(SpiceLevel.NoSpice, SpiceLevel.ExtraHot);
        List<Allergen> allergens = new ArrayList<Allergen>();
        allergens.add(Allergen.Dairy);
        allergens.add(Allergen.Nuts);
        Range<Integer> priceRange = command.new Range<Integer>(0, 25);
        List<Cuisine> cuisines = new ArrayList<Cuisine>();
        cuisines.add(Cuisine.NoPreference);
        List<MealType> mealTypes = new ArrayList<MealType>();
        mealTypes.add(MealType.Chicken);

        command.setDoneeId(100);

        command.setSpiceRange(spiceRange);
        command.setPriceRange(priceRange);

        command.setAllergens(allergens);
        command.setMealTypes(mealTypes);
        command.setCuisines(cuisines);

        Response<Void> response = handler.handle(command);
        assert (response.getError()==Error.DoneeDoesNotExist);

    }

    @Test
    public void InvalidPriceRangeTest(){
        SelectPreferencesCommand command = new SelectPreferencesCommand();

        Range<SpiceLevel> spiceRange = command.new Range<SpiceLevel>(SpiceLevel.NoSpice, SpiceLevel.ExtraHot);
        List<Allergen> allergens = new ArrayList<Allergen>();
        allergens.add(Allergen.Dairy);
        allergens.add(Allergen.Nuts);
        Range<Integer> priceRange = command.new Range<Integer>(-5, 25);
        List<Cuisine> cuisines = new ArrayList<Cuisine>();
        cuisines.add(Cuisine.NoPreference);
        List<MealType> mealTypes = new ArrayList<MealType>();
        mealTypes.add(MealType.Chicken);

        command.setDoneeId(donee.getId());

        command.setSpiceRange(spiceRange);
        command.setPriceRange(priceRange);

        command.setAllergens(allergens);
        command.setMealTypes(mealTypes);
        command.setCuisines(cuisines);

        Response<Void> response1 = handler.handle(command);

        Range<Integer> priceRange2 = command.new Range<Integer>(28, 25);
        command.setPriceRange(priceRange2);
        Response<Void> response2 = handler.handle(command);

        assert (response1.getError()==Error.InvalidPriceRange && response2.getError()==Error.InvalidPriceRange );

    }


    @Test
    public void InvalidSpiceRangeTest(){


        SelectPreferencesCommand command = new SelectPreferencesCommand();

        Range<SpiceLevel> spiceRange = command.new Range<SpiceLevel>( SpiceLevel.ExtraHot, SpiceLevel.NoSpice);
        List<Allergen> allergens = new ArrayList<Allergen>();
        allergens.add(Allergen.Dairy);
        allergens.add(Allergen.Nuts);
        Range<Integer> priceRange = command.new Range<Integer>(0, 25);
        List<Cuisine> cuisines = new ArrayList<Cuisine>();
        cuisines.add(Cuisine.NoPreference);
        List<MealType> mealTypes = new ArrayList<MealType>();
        mealTypes.add(MealType.Chicken);

        command.setDoneeId(donee.getId());

        command.setSpiceRange(spiceRange);
        command.setPriceRange(priceRange);

        command.setAllergens(allergens);
        command.setMealTypes(mealTypes);
        command.setCuisines(cuisines);

        Response<Void> response = handler.handle(command);

        assert (response.getError()==Error.InvalidSpiceRange );

    }
}
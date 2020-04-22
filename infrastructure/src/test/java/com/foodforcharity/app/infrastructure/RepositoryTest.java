package com.foodforcharity.app.infrastructure;

import com.foodforcharity.app.domain.constant.*;
import com.foodforcharity.app.domain.entity.*;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.infrastructure.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

 @RunWith(SpringRunner.class)
 @SpringBootTest
public class RepositoryTest {

    @Autowired
    FoodRepository foodRepos;

    @Autowired
    DonorRepository donorRepos;

    @Autowired
    DoneeRepository doneeRepos;

    @Autowired
    RequestRepository requestRepos;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void contextLoads() {
        assert (foodRepos != null && doneeRepos != null && doneeRepos != null && requestRepos != null);
    }

    @Test
    public void success() {

        Donor donor = new Donor();
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

        Food food = new Food();
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

        Donee donee = new Donee();
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

        SubRequest subRequest = new SubRequest();
        subRequest.setFood(food);
        subRequest.setQuantity(1);
        subRequest.setPriceAtPurchase(food.getPrice() * (100 - donor.getDiscountApplied() / 100));

        Request request = new Request();
        request.addSubRequest(subRequest);
        request.setDiscountApplied(donor.getDiscountApplied());
        request.setDonee(donee);
        request.setDonor(donor);
        request.setFinalPrice(food.getPrice() * (100 - donor.getDiscountApplied() / 100));
        request.setIsActive(true);
        request.setRequestTime(new Date());
        request.setIsRated(false);
        request = requestRepos.save(request);

        donor = ((DonorService) donorRepos).findById(donor.getId()).get();

        requestRepos.deleteAll(donor.getRequests());

        foodRepos.deleteById(food.getId());


        donorRepos.deleteById(donor.getId());
//
        donee = ((DoneeService) doneeRepos).findById(donee.getId()).get();
        doneeRepos.delete(donee);

    }
}

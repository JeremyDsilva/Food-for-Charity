package com.foodforcharity.app.usecase.profile.addmenu;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.mediator.CommandHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddMenuCommandHandler implements CommandHandler<AddMenuCommand, Response<Void>> {
	DonorService donorService;
	FoodService foodService;

	/**
	 * Public Constructor
	 * 
	 * @param donorService
	 * @param foodService
	 */
	@Autowired
	public AddMenuCommandHandler(DonorService donorService, FoodService foodService) {
		this.donorService = donorService;
		this.foodService = foodService;
	}

	/**
	 * @param AddMenuCommand
	 * @return Response<void>
	 * @throws Error.Unknown
	 */
	@Override
	public Response<Void> handle(AddMenuCommand command) {
		try {
			Integer minimumValue = 0;
			// check that original price is not less than 0

			if (command.originalPrice < minimumValue) {
				return Response.of(Error.InvalidOriginalPrice);
			}

			// check that MealforN people is not less than or equal to 0
			if (command.mealForNPeople <= minimumValue) {
				return Response.of(Error.InvalidMealSize);
			}

			// check that quantity available is not less than 0
			if (command.quantityAvailable < minimumValue) {
				return Response.of(Error.InvalidQuantityAvailable);
			}
			// check that description is not empty
			if (command.descriptionText.isBlank()) {
				return Response.of(Error.InvalidFoodDescriptionText);
			}

			// check that foodname is not empty

			if (command.foodName.isBlank()) {
				return Response.of(Error.InvalidFoodName);
			}

			// check that donee id exists and is active or inactive
			Optional<Donor> dbDonor = donorService.findById(command.donorId);
			if (dbDonor.isEmpty()) {
				return Response.of(Error.DonorDoesNotExist);
			}
			Donor donor = dbDonor.get();
			if (donor.getDonorStatus().equals(DonorStatus.Initial)
					|| donor.getDonorStatus().equals(DonorStatus.Suspended)) {
				return Response.of(Error.IneligibleDonorStatus);
			}

			// since everything is successfullcreat a food Item
			Food food = new Food();
			food.setFoodName(command.foodName);
			food.setDescriptionText(command.descriptionText);
			food.setPrice(command.originalPrice);
			food.setMealForNPeople(command.mealForNPeople);
			food.setQuantityAvailable(command.quantityAvailable);
			food.setCuisine(command.cuisine);
			food.setMealType(command.mealType); // method takes a set but we decided to
			//make it a single value
			food.setSpiceLevel(command.spiceLevel);
			food.setAllergens(command.allergens);

			// add food item to donors menu
			donor.getFoods().add(food);
			food.setDonor(donor);
			// save to donorService
			

			donorService.save(donor);

		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}
		return Response.EmptyResponse();
	}

}
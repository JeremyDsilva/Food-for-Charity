package com.foodforcharity.app.usecase.profile.modifymenuitem;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.mediator.CommandHandler;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyMenuItemCommandHandler implements CommandHandler<ModifyMenuItemCommand, Response<Void>> {
	FoodService foodService;

	/**
	 * Public Constructor
	 * 
	 * @param foodService
	 */
	@Autowired
	public ModifyMenuItemCommandHandler(FoodService foodService) {
		this.foodService = foodService;
	}

	@Override
	public Response<Void> handle(ModifyMenuItemCommand command) {

		try {

			// check that food id exists
			Optional<Food> dbFood = foodService.findById(command.foodId);
			if (dbFood.isEmpty()) {
				return Response.of(Error.FoodDoesNotExist);
			}
			Food food = dbFood.get();

			// check that donor and food's donor match
			if (command.donorId != food.getDonor().getId()) {
				return Response.of(Error.FoodsDonorMismatch);
			}

			Integer minimumValue = 0;

			// check that original price is not less than 0
			if (command.originalPrice.isPresent() && command.originalPrice.get() < minimumValue) {
				return Response.of(Error.InvalidOriginalPrice);
			}

			// check that MealforN people is not less than or equal to 0
			if (command.mealForNPeople.isPresent() && command.mealForNPeople.get() <= minimumValue) {
				return Response.of(Error.InvalidMealSize);
			}

			// check that quantity available is not less than 0
			if (command.quantityAvailable.isPresent() && command.quantityAvailable.get() < minimumValue) {
				return Response.of(Error.InvalidQuantityAvailable);
			}
			// check that description is not empty
			if (command.descriptionText.isPresent() && command.descriptionText.get().isBlank()) {
				return Response.of(Error.InvalidFoodDescriptionText);
			}

			// check that foodname is not empty
			if (command.foodName.isPresent() && command.foodName.get().isBlank()) {
				return Response.of(Error.InvalidFoodName);
			}

			command.foodName.ifPresent(x ->food.setFoodName(x)) ;
			command.descriptionText.ifPresent(x -> food.setDescriptionText(x));
			command.originalPrice.ifPresent(x -> food.setPrice(x));
			command.mealForNPeople.ifPresent(x -> food.setMealForNPeople(x));
			command.quantityAvailable.ifPresent(x -> food.setQuantityAvailable(x));
			command.cuisine.ifPresent(x -> food.setCuisine(x));
			command.mealType.ifPresent(x -> food.setMealType(x));
			command.spiceLevel.ifPresent(x -> food.setSpiceLevel(x));
			
			food.setAllergens(command.allergens);

			// save to foodService
			foodService.save(food);

		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}

		return Response.EmptyResponse();
	}

}

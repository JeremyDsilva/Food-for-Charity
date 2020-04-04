package com.foodforcharity.app.usecase.profile.modifymenuitem;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.FoodRepository;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyMenuItemCommandHandler implements CommandHandler<ModifyMenuItemCommand, Response<Void>> {
	FoodRepository foodRepository;

	/**
	 * Public Constructor
	 * 
	 * @param foodRepository
	 */
	@Autowired
	public ModifyMenuItemCommandHandler(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	@Override
	public Response<Void> handle(ModifyMenuItemCommand command) {

		try {

			// check that food id exists
			Optional<Food> dbFood = foodRepository.findById(command.foodId);
			if (dbFood.isEmpty()) {
				return Response.of(Error.DonorDoesNotExist);
			}
			Food food = dbFood.get();

			// check that donor and food's donor match
			if (command.donorId == food.getDonor().getId()) {
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

			if (command.foodName.isPresent()) {
				food.setFoodName(command.foodName.get());
			}
			if (command.descriptionText.isPresent()) {
				food.setDescriptionText(command.descriptionText.get());
			}
			if (command.originalPrice.isPresent()) {
				food.setPrice(command.originalPrice.get());
			}
			if (command.mealForNPeople.isPresent()) {
				food.setMealForNPeople(command.mealForNPeople.get());
			}
			if (command.quantityAvailable.isPresent()) {
				food.setQuantityAvailable(command.quantityAvailable.get());
			}

			if (command.cuisine.isPresent()) {
				food.setCuisines(command.cuisine.get());
			}
			if (command.mealType.isPresent()) {
				food.setMealType(command.mealType.get());
				// method takes a set but we decided to make it a single value}
				{
					food.setSpiceLevel(command.spiceLevel.get());
				}

				food.setAllergens(command.allergens);

				// save to foodRepository
				foodRepository.save(food);

			}
		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}

		return Response.EmptyResponse();
	}

}

package com.foodforcharity.app.usecase.profile.modifymenuitem;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.mediator.Command;

public class ModifyMenuItemCommand implements Command<Void> {

	long donorId;

	long foodId;

	Optional<String> descriptionText;

	Optional<Integer> mealForNPeople;

	Optional<Integer> originalPrice;

	Optional<Integer> quantityAvailable;
	Optional<Cuisine> cuisine;
	Optional<MealType> mealType;
	Optional<List<Allergen>> allergens;

	public ModifyMenuItemCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param donorId
	 * @param foodId
	 */
	public ModifyMenuItemCommand(long donorId, long foodId) {
		this.donorId = donorId;
		this.foodId = foodId;
		this.descriptionText = Optional.empty();
		this.mealForNPeople = Optional.empty();
		this.originalPrice = Optional.empty();
		this.quantityAvailable = Optional.empty();
		this.cuisine = Optional.empty();
		this.mealType = Optional.empty();
		this.allergens = Optional.empty();
	}

	/**
	 * 
	 * @param allergens
	 */
	public void setAllergens(List<Allergen> allergens) {
		this.allergens = Optional.of(allergens);
	}

	/**
	 * @param descriptionText the descriptionText to set
	 * @return
	 */
	public void setDescriptionText(String descriptionText) {
		this.descriptionText = Optional.of(descriptionText);
	}

	/**
	 * @param mealForNPeople the mealForNPeople to set
	 * @return
	 */
	public void setMealForNPeople(Integer mealForNPeople) {
		this.mealForNPeople = Optional.of(mealForNPeople);
	}

	/**
	 * @param price the price to set
	 * @return
	 */
	public void setPrice(Integer price) {
		this.originalPrice = Optional.of(price);
	}

	/**
	 * 
	 * @param quantityAvailable
	 * @return
	 */
	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = Optional.of(quantityAvailable);
	}

	/**
	 * 
	 * @param cuisines
	 */
	public void setCuisine(Cuisine cuisines) {
		this.cuisine = Optional.of(cuisines);
	}

	/**
	 * 
	 * @param mealTypes
	 */
	public void setMealType(MealType mealTypes) {
		this.mealType = Optional.of(mealTypes);
	}


}
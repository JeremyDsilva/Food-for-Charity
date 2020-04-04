package com.foodforcharity.app.usecase.profile.modifymenuitem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class ModifyMenuItemCommand implements Command<Response<Void>> {

	long donorId;

	long foodId;
	Optional<String> foodName;
	Optional<String> descriptionText;

	Optional<Integer> mealForNPeople;

	Optional<Integer> originalPrice;

	Optional<Integer> quantityAvailable;
	Optional<Cuisine> cuisine;
	Optional<MealType> mealType;
	Set<Allergen> allergens;
	Optional<SpiceLevel> spiceLevel;

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
		this.foodName= Optional.empty();
		this.descriptionText = Optional.empty();
		this.mealForNPeople = Optional.empty();
		this.originalPrice = Optional.empty();
		this.quantityAvailable = Optional.empty();
		this.cuisine = Optional.empty();
		this.mealType = Optional.empty();
		this.allergens = new HashSet<Allergen>();
		this.spiceLevel= Optional.empty();
	}

	/**
	 * 
	 * @param allergens
	 */
	public void setAllergens(Set<Allergen> allergens) {
		this.allergens = allergens;
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

	/**
	 * 
	 * @return
	 */
	public Optional<String> getFoodName() {
		return foodName;
	}

	/**
	 * 
	 * @param foodName
	 */
	public void setFoodName(String foodName) {
		this.foodName = Optional.of(foodName);
	}

	/**
	 * 
	 * @return
	 */
	public Optional<SpiceLevel> getSpiceLevel() {
		return spiceLevel;
	}

	/**
	 * 
	 * @param spiceLevel
	 */
	public void setSpiceLevel(SpiceLevel spiceLevel) {
		this.spiceLevel = Optional.of(spiceLevel);
	}

}
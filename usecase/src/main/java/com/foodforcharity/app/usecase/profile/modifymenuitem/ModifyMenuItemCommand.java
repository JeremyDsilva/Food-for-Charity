package com.foodforcharity.app.usecase.profile.modifymenuitem;

import java.util.Optional;

import com.foodforcharity.app.mediator.Command;

public class ModifyMenuItemCommand implements Command<Void> {
	long donorId;
	long foodId;
	Optional<String> foodName;
	Optional<String> descriptionText;
	Optional<Integer> originalPrice;
	Optional<Integer> mealForNPeople;
	Optional<Integer> quantityAvailable;
	Optional<String> spiceLevel; // varchar in db -> what should the datatype be?

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
	}

	public ModifyMenuItemCommand setFoodName(Optional<String> foodName) {
		this.foodName = foodName;
		return this;
	}

	public ModifyMenuItemCommand setDescriptionText(Optional<String> descriptionText) {
		this.descriptionText = descriptionText;
		return this;
	}

	public ModifyMenuItemCommand setOriginalPrice(Optional<Integer> originalPrice) {
		this.originalPrice = originalPrice;
		return this;
	}

	public ModifyMenuItemCommand setMealForNPeople(Optional<Integer> mealForNPeople) {
		this.mealForNPeople = mealForNPeople;
		return this;
	}

	public ModifyMenuItemCommand setQuantityAvailable(Optional<Integer> quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
		return this;
	}

	public ModifyMenuItemCommand setSpiceLevel(Optional<String> spiceLevel) {
		this.spiceLevel = spiceLevel;
		return this;
	}

}
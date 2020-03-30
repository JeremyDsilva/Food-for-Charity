package com.foodforcharity.app.usecase.profile.addmenu;

import com.foodforcharity.app.mediator.Command;

public class AddMenuCommand implements Command<Void> {
	long donorId;
	String foodName;
	String descriptionText;
	int originalPrice;
	int mealForNPeople;
	int quantityAvailable;
	String spiceLevel; // varchar in db -> what should the datatype be?

	public AddMenuCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param donorId
	 * @param foodName
	 * @param descriptionText
	 * @param originalPrice
	 * @param mealForNPeople
	 * @param quantityAvailable
	 * @param spiceLevel
	 */
	public AddMenuCommand(long donorId, String foodName, String descriptionText, int originalPrice, int mealForNPeople,
			int quantityAvailable, String spiceLevel) {
		this.donorId = donorId;
		this.foodName = foodName;
		this.descriptionText = descriptionText;
		this.originalPrice = originalPrice;
		this.mealForNPeople = mealForNPeople;
		this.quantityAvailable = quantityAvailable;
		this.spiceLevel = spiceLevel;
	}

}
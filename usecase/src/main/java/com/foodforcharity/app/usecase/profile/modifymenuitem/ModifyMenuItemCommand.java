package com.foodforcharity.app.usecase.profile.modifymenuitem;

import java.util.Optional;

import com.foodforcharity.app.mediator.Command;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.Op;

public class ModifyMenuItemCommand implements Command<Void> {

	long donorId;

	long foodId;

	Optional<String> descriptionText;

	Optional<Integer> mealForNPeople;

	Optional<Integer> originalPrice;

	Optional<Integer> quantityAvailable;

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

}
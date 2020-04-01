package com.foodforcharity.app.usecase.foodreservation.createrequest;

import java.util.List;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class CreateRequestCommand implements Command<Response<Void>> {
	// donee id, donorid, food id, qty of each food
	long doneeId;
	long donorId;
	List<FoodQuantityPair> foodQuantityPairs;

	public class FoodQuantityPair {
		long foodId;
		int quantity;

		public FoodQuantityPair(long foodId, int quantity) {
			this.foodId = foodId;
			this.quantity = quantity;
		}
	}

	public CreateRequestCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param doneeId
	 * @param donorId
	 * @param foodQuantityPairs
	 */
	public CreateRequestCommand(long doneeId, long donorId, List<FoodQuantityPair> foodQuantityPairs) {
		this.doneeId = doneeId;
		this.donorId = donorId;
		this.foodQuantityPairs = foodQuantityPairs;
	}

	/**
	 * Public Constructor
	 * 
	 * @param doneeId
	 * @param donorId
	 */
	public CreateRequestCommand(long doneeId, long donorId) {
		this.doneeId = doneeId;
		this.donorId = donorId;
	}

	public void addFood(long foodId, int quantity){
		foodQuantityPairs.add(new FoodQuantityPair(foodId, quantity));
	}


}
package com.foodforcharity.app.usecase.foodreservation.createrequest;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;

import java.util.ArrayList;
import java.util.List;

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
            foodQuantityPairs = new ArrayList<FoodQuantityPair>();
        }
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

    public void addFood(long foodId, int quantity) {
        FoodQuantityPair foodQuantityPair = new FoodQuantityPair(foodId, quantity);
        foodQuantityPairs.add(foodQuantityPair);
    }


}
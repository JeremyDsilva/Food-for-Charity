package com.foodforcharity.app.usecase.profile.addmenu;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import java.util.Set;

public class AddMenuCommand implements Command<Response<Void>> {

    long donorId;
    String foodName;
    String descriptionText;
    int originalPrice;
    int mealForNPeople;
    int quantityAvailable;
    SpiceLevel spiceLevel;
    MealType mealType;
    Cuisine cuisine;
    /*
     * optional becasue not every food item  doesnt necessarily has an allergen
     */
    Set<Allergen> allergens;

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
     * @param mealType
     * @param cuisine
     * @param allergens
     */
    public AddMenuCommand(long donorId, String foodName, String descriptionText, int originalPrice, int mealForNPeople,
                          int quantityAvailable, SpiceLevel spiceLevel, MealType mealType, Cuisine cuisine,
                          Set<Allergen> allergens) {
        this.donorId = donorId;
        this.foodName = foodName;
        this.descriptionText = descriptionText;
        this.originalPrice = originalPrice;
        this.mealForNPeople = mealForNPeople;
        this.quantityAvailable = quantityAvailable;
        this.spiceLevel = spiceLevel;
        this.mealType = mealType;
        this.cuisine = cuisine;
        this.allergens = allergens;
    }


}
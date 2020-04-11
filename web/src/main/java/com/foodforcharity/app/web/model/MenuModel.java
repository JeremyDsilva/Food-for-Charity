package com.foodforcharity.app.web.model;

import java.io.Serializable;
import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;

public class MenuModel implements Serializable{

    String foodName;
    String descriptionText;
    int originalPrice;
    int mealForNPeople;
    int quantityAvailable;
    String spiceLevel;
    String mealType;
    String cuisine;
    Set<Allergen> allergen;

    public MenuModel(){

    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescriptionText() {
        return this.descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public int getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getMealForNPeople() {
        return this.mealForNPeople;
    }

    public void setMealForNPeople(int mealForNPeople) {
        this.mealForNPeople = mealForNPeople;
    }

    public int getQuantityAvailable() {
        return this.quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getSpiceLevel() {
        return this.spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String getMealType() {
        return this.mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Set<Allergen> getAllergen() {
        return this.allergen;
    }

    public void setAllergen(Set<Allergen> allergen) {
        this.allergen = allergen;
    }

    
    

}
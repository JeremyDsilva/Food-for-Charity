package com.foodforcharity.app.web.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.constant.Allergen;

public class MenuModel extends Request{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Food name cannot be empty")
    private String foodName;
    
    @NotNull(message = "Description text cannot be empty")
    private String descriptionText;
    
    @NotNull(message = "Price cannot be empty")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "Price should be digitis and 2 decimals only")
    private int originalPrice;
    
    @NotNull(message = "Meal for number of people cannot be empty")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "The number should be digits")
    private int mealForNPeople;
    
    @NotNull(message = "Quantity available cannot be empty")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "The number should be digits")
    private int quantityAvailable;
    
    @NotNull(message = "Meal for number of people cannot be empty")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "The number should be digits")
    private String spiceLevel;
    
    @NotNull(message = "Meal type cannot be empty")
    private String mealType;
    
    @NotNull(message = "Cuisine cannot be empty")
    private String cuisine;
    
    @NotNull(message = "Allergen cannot be empty")
    private Set<Allergen> allergen;

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
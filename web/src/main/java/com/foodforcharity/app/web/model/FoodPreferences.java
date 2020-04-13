package com.foodforcharity.app.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;

public class FoodPreferences implements Serializable{


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Range<SpiceLevel> spiceRange;
    private List<Allergen> allergens;
    private Range<Integer> priceRange;
    private List<Cuisine> cuisines;
    private List<MealType> mealTypes;

    public FoodPreferences(){
        
    }

    public Range<SpiceLevel> getSpiceRange() {
        return this.spiceRange;
    }

    public void setSpiceRange(Range<SpiceLevel> spiceRange) {
        this.spiceRange = spiceRange;
    }

    public List<Allergen> getAllergens() {
        return this.allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    public Range<Integer> getPriceRange() {
        return this.priceRange;
    }

    public void setPriceRange(Range<Integer> priceRange) {
        this.priceRange = priceRange;
    }

    public List<Cuisine> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<MealType> getMealTypes() {
        return this.mealTypes;
    }

    public void setMealTypes(List<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }

    
    
}
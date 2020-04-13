package com.foodforcharity.app.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;

public class CreateRequest implements Serializable{


    Optional<Range<SpiceLevel>> spiceRange;
    Optional<List<Allergen>> allergens;
    Optional<Range<Integer>> priceRange;
    Optional<List<Cuisine>> cuisines;
    Optional<List<MealType>> mealTypes;

    public Optional<Range<SpiceLevel>> getSpiceRange() {
        return this.spiceRange;
    }

    public void setSpiceRange(Optional<Range<SpiceLevel>> spiceRange) {
        this.spiceRange = spiceRange;
    }

    public Optional<List<Allergen>> getAllergens() {
        return this.allergens;
    }

    public void setAllergens(Optional<List<Allergen>> allergens) {
        this.allergens = allergens;
    }

    public Optional<Range<Integer>> getPriceRange() {
        return this.priceRange;
    }

    public void setPriceRange(Optional<Range<Integer>> priceRange) {
        this.priceRange = priceRange;
    }

    public Optional<List<Cuisine>> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(Optional<List<Cuisine>> cuisines) {
        this.cuisines = cuisines;
    }

    public Optional<List<MealType>> getMealTypes() {
        return this.mealTypes;
    }

    public void setMealTypes(Optional<List<MealType>> mealTypes) {
        this.mealTypes = mealTypes;
    }
    
    
}
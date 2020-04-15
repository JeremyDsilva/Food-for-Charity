package com.foodforcharity.app.web.model;

import java.util.List;

import javax.validation.constraints.Digits;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;

import lombok.Data;

@Data
public class FoodPreferences extends Request{


    /**
     *
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Spice range should be in digits")
    private Range<SpiceLevel> spiceRange;

    private List<Allergen> allergens;
    
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Price range should be in digits")
    private Range<Integer> priceRange;
    
    private List<Cuisine> cuisines;
    
    private List<MealType> mealTypes;

    
}
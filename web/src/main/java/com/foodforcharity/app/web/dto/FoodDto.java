package com.foodforcharity.app.web.dto;

import java.util.Set;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Food;

import lombok.Data;

@Data
public class FoodDto {

    private long id;

    private String descriptionText;

    private String foodName;

    private Integer mealForNPeople;

    private Double price;

    private Integer quantityAvailable;

    private SpiceLevel spiceLevel;

    private Set<Allergen> allergens;

    private Cuisine cuisine;

    private MealType mealType;

    public FoodDto(Food food){
        this.allergens = food.getAllergens();
        this.cuisine = food.getCuisines();
        this.descriptionText = food.getDescriptionText();
        this.foodName = food.getFoodName();
        this.id = food.getId();
        this.mealForNPeople = food.getMealForNPeople();
        this.mealType = food.getMealType();
        this.price = food.getPrice() / 100.0;
        this.quantityAvailable = food.getQuantityAvailable();
        this.spiceLevel = food.getSpiceLevel();
    }

}
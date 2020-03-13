package com.foodforcharity.app.domain;

import java.util.List;

import com.foodforcharity.common.Enum.Allergen;
import com.foodforcharity.common.Enum.Cuisine;
import com.foodforcharity.common.Enum.MealType;
import com.foodforcharity.common.Enum.SpiceLevel;


public class Food {

  long id;

  String foodName;

  String descriptionText;

  int price;

  SpiceLevel spiceLevel;
  
  int quantityAvailable;

  // Donor donor;

  List<Allergen> allergens;

  List<MealType> mealTypes;

  List<Cuisine> cuisines;

}

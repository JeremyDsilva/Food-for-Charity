package com.foodforcharity.app.domain;

import java.util.List;

import com.foodforcharity.common.Authority.DoneeStatus;
import com.foodforcharity.common.Enum.Allergen;
import com.foodforcharity.common.Enum.Cuisine;
import com.foodforcharity.common.Enum.DoneeType;
import com.foodforcharity.common.Enum.MealType;

public class Donee extends Person {
  
  private long doneeId;

  String doneeName;

  String phoneNumber;

  String email;

  String addressDescription;

  String city;

  String country;

  DoneeStatus doneeStatus;

  DoneeType doneeType;

  int memberCount;

  int quantityRequested;

 
  List<Allergen> allergens;

  
  List<MealType> mealTypes;

  
  List<Cuisine> cuisines;


  DoneePriceRange priceRange;


  DoneeSpiceRange spiceRange;

}

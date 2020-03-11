package com.foodforcharity.app.domain;

import java.util.List;

import com.foodforcharity.common.Enum.*;

public class Donee {
  
  long id;

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

  Person person;

}

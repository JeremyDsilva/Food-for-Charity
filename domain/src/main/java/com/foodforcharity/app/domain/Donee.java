package com.foodforcharity.app.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.foodforcharity.common.Authority;
import com.foodforcharity.common.Authority.DoneeStatus;
import com.foodforcharity.common.Authority.PersonRole;
import com.foodforcharity.common.Enum.*;

import org.springframework.security.core.GrantedAuthority;

public class Donee extends Person {
  
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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return Arrays.asList(new Authority(PersonRole.Donor, doneeStatus));
  }  
}

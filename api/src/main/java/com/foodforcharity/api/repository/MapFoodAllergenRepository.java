package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapFoodAllergen; 

 @Repository 
 public interface MapFoodAllergenRepository extends CrudRepository<MapFoodAllergen,Integer>{ 
 }
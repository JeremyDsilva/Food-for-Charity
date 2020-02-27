package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapFoodMealType; 

 @Repository 
 public interface MapFoodMealTypeRepository extends CrudRepository<MapFoodMealType,Integer>{ 
 }
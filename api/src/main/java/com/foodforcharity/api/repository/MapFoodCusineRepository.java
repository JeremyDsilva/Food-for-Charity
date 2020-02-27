package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapFoodCusine; 

 @Repository 
 public interface MapFoodCusineRepository extends CrudRepository<MapFoodCusine,Integer>{ 
 }
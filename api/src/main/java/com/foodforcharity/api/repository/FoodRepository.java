package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Food; 

 @Repository 
 public interface FoodRepository extends CrudRepository<Food,Integer>{ 
 }
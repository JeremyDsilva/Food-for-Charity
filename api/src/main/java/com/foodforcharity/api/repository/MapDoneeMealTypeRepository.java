package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapDoneeMealType; 

 @Repository 
 public interface MapDoneeMealTypeRepository extends CrudRepository<MapDoneeMealType,Integer>{ 
 }
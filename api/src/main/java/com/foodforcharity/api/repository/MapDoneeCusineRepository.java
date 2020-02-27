package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapDoneeCusine; 

 @Repository 
 public interface MapDoneeCusineRepository extends CrudRepository<MapDoneeCusine,Integer>{ 
 }
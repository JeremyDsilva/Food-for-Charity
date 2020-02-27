package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapDoneeAllergen; 

 @Repository 
 public interface MapDoneeAllergenRepository extends CrudRepository<MapDoneeAllergen,Integer>{ 
 }
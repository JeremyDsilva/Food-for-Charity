package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Allergen; 

 @Repository 
 public interface AllergenRepository extends CrudRepository<Allergen,Integer>{ 
 }
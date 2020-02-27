package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.DoneeType; 

 @Repository 
 public interface DoneeTypeRepository extends CrudRepository<DoneeType,Integer>{ 
 }
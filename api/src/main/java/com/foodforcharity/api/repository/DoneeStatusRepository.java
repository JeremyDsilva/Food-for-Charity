package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.DoneeStatus; 

 @Repository 
 public interface DoneeStatusRepository extends CrudRepository<DoneeStatus,Integer>{ 
 }
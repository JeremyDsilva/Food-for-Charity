package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Donee; 

 @Repository 
 public interface DoneeRepository extends CrudRepository<Donee,Integer>{ 
 }
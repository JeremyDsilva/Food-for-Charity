package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Person; 

 @Repository 
 public interface PersonRepository extends CrudRepository<Person,Integer>{ 
 }
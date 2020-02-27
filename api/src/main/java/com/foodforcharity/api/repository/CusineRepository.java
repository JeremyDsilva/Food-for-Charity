package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Cusine; 

 @Repository 
 public interface CusineRepository extends CrudRepository<Cusine,Integer>{ 
 }
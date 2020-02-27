package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.Request; 

 @Repository 
 public interface RequestRepository extends CrudRepository<Request,Integer>{ 
 }
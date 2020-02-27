package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.MapPersonRole; 

 @Repository 
 public interface MapPersonRoleRepository extends CrudRepository<MapPersonRole,Integer>{ 
 }
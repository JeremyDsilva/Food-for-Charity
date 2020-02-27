package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.PersonRole; 

 @Repository 
 public interface PersonRoleRepository extends CrudRepository<PersonRole,Integer>{ 
 }
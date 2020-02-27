package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.DonorStatus; 

 @Repository 
 public interface DonorStatusRepository extends CrudRepository<DonorStatus,Integer>{ 
 }
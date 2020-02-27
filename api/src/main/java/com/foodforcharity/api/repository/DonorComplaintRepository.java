package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.DonorComplaint; 

 @Repository 
 public interface DonorComplaintRepository extends CrudRepository<DonorComplaint,Integer>{ 
 }
package com.foodforcharity.api.repository;

import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
import com.foodforcharity.api.entities.DoneeComplaint; 

 @Repository 
 public interface DoneeComplaintRepository extends CrudRepository<DoneeComplaint,Integer>{ 
 }
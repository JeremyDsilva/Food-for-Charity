package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
}
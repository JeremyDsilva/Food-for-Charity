package com.foodforcharity.api.repository;

import java.util.List;

import com.foodforcharity.api.entities.Complaint;
import com.foodforcharity.api.entities.Request;

import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    List<Complaint> findAllByRequest(Request request);
    List<Complaint> findAllByFromDoneeAndIsActive(Boolean fromDonee, Boolean isActive);
}
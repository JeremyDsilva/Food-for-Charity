package com.foodforcharity.app.service;

import java.util.List;

import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.entity.Request;

import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    List<Complaint> findAllByRequest(Request request);
    List<Complaint> findAllByFromDoneeAndIsActive(Boolean fromDonee, Boolean isActive);
}
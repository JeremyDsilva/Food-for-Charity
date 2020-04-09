package com.foodforcharity.app.domain.service;

import java.util.List;

import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.entity.Request;

import org.springframework.stereotype.Component;

@Component
public interface ComplaintService extends Service<Complaint> {
    List<Complaint> findAllByRequest(Request request);
    List<Complaint> findAllByFromDoneeAndIsActive(Boolean fromDonee, Boolean isActive);
}
package com.foodforcharity.app.infrastructure.repository;

import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.service.ComplaintService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Long>, ComplaintService {
    // List<Complaint> findAllByRequest(Request request);
    // List<Complaint> findAllByFromDoneeAndIsActive(Boolean fromDonee, Boolean isActive);
}
package com.foodforcharity.app.infrastructure.repository;

import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.service.RequestService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long>, RequestService {
}
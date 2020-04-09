package com.foodforcharity.app.infrastructure.repository;


import com.foodforcharity.app.domain.entity.ErrorLog;
import com.foodforcharity.app.domain.service.ErrorLogService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorLogRepository extends CrudRepository<ErrorLog, Long>, ErrorLogService {
}
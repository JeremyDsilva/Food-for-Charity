package com.foodforcharity.app.service;


import com.foodforcharity.app.domain.entity.ErrorLog;

import org.springframework.data.repository.CrudRepository;

public interface ErrorLogRepository extends CrudRepository<ErrorLog, Long> {
}
package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.ErrorLog;

import org.springframework.data.repository.CrudRepository;

public interface ErrorLogRepository extends CrudRepository<ErrorLog, Long> {
}
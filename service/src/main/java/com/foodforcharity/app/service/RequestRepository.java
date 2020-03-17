package com.foodforcharity.app.service;

import com.foodforcharity.app.domain.entity.Request;

import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {   
}
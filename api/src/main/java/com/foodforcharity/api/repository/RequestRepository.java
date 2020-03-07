package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.Request;

import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {   
}
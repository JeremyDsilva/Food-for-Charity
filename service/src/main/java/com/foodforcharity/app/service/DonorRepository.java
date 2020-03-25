package com.foodforcharity.app.service;

import com.foodforcharity.app.domain.entity.Donor;

import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<Donor, Long> {
}
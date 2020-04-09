package com.foodforcharity.app.infrastructure.repository;

import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.service.DonorService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long>, DonorService {
}
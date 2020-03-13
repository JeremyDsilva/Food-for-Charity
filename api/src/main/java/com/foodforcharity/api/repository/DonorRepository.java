package com.foodforcharity.api.repository;

import java.util.Optional;

import com.foodforcharity.api.entities.Donor;

import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<Donor, Long> {
    Optional<Donor> findByDonorId(long donorId);
}
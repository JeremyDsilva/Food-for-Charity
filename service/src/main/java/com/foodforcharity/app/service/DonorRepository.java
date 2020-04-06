package com.foodforcharity.app.service;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.domain.entity.Donor;

import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<Donor, Long> {
    List<Donor> findByDonorName(String donorName);
    Optional<Donor> findByUsername(String username);
}
package com.foodforcharity.api.repository;

import java.util.Optional;

import com.foodforcharity.api.entities.Donee;

import org.springframework.data.repository.CrudRepository;

public interface DoneeRepository extends CrudRepository<Donee, Long> {
    Optional<Donee> findByDoneeId(long donorId);
}
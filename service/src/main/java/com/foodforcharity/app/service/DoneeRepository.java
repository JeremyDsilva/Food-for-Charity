package com.foodforcharity.app.service;

import java.util.List;

import com.foodforcharity.app.domain.entity.Donee;

import org.springframework.data.repository.CrudRepository;

public interface DoneeRepository extends CrudRepository<Donee, Long> {
    List<Donee> findByDoneeName(String doneeName);
}
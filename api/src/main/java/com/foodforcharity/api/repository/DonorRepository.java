package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.Donor;
import com.foodforcharity.api.entities.Person;

import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<Donor, Long> {
    Donor findByPerson(Person person);
}
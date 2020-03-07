package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.Donee;
import com.foodforcharity.api.entities.Person;

import org.springframework.data.repository.CrudRepository;

public interface DoneeRepository extends CrudRepository<Donee, Long> {
    Donee findByPerson(Person person);
}
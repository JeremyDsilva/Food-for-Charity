package com.foodforcharity.api.repository;

import com.foodforcharity.api.entities.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
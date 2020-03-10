package com.foodforcharity.api.repository;

import java.util.Optional;

import com.foodforcharity.api.entities.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
}
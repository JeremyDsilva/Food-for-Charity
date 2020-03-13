package com.foodforcharity.api.repository;

import java.util.Optional;

import com.foodforcharity.api.entities.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByUsername(String username);
}
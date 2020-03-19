package com.foodforcharity.app.service;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByUsername(String username);
    
}
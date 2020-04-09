package com.foodforcharity.app.infrastructure.repository;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.service.PersonService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PersonService {

    Optional<Person> findByUsername(String username);
    
}
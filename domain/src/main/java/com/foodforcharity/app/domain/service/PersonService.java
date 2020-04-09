package com.foodforcharity.app.domain.service;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Person;

import org.springframework.stereotype.Component;

@Component
public interface PersonService extends Service<Person> {

    Optional<Person> findByUsername(String username);
    
}
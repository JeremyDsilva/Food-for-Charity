package com.foodforcharity.app.domain.service;

import com.foodforcharity.app.domain.entity.Person;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PersonService extends Service<Person> {

    Optional<Person> findByUsername(String username);

}
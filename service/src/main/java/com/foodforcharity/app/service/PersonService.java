package com.foodforcharity.app.service;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Person;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }




}
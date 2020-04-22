package com.foodforcharity.app.infrastructure.security;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.domain.security.PersonDetailsService;
import com.foodforcharity.app.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service to associate user with password and roles setup in the database.
 */
@Service
public class PersonDetailsServiceImplementaion implements PersonDetailsService {

    private final PersonService personService;


    @Autowired
    PersonDetailsServiceImplementaion(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public PersonDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personService.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with name %s does not exist", s)));

        return new PersonDetails(person);
    }


}
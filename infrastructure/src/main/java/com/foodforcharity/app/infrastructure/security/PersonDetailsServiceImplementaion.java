package com.foodforcharity.app.infrastructure.security;

import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.security.JwtProviderService;
import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.domain.security.PersonDetailsService;
import com.foodforcharity.app.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service to associate user with password and roles setup in the database.
 *
 */
@Service
public class PersonDetailsServiceImplementaion implements PersonDetailsService {

    private final PersonService personService;

    private final JwtProviderService jwtProvider;

    @Autowired
    PersonDetailsServiceImplementaion(PersonService personService, JwtProviderService jwtProvider) {
        this.personService = personService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public PersonDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personService.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with name %s does not exist", s)));

        return new PersonDetails(person);
    }

    /**
     * Extract the username from the JWT then lookup the user in the database.
     *
     * @param jwtToken
     * @return
     */
    public Optional<PersonDetails> loadUserByJwtTokenAndDatabase(String jwtToken) {
        if (jwtProvider.isValidToken(jwtToken)) {
            return Optional.of(loadUserByUsername(jwtProvider.getUsername(jwtToken)));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Extract username and roles from a validated jwt string.
     *
     * @param jwtToken jwt string
     * @return UserDetails if valid, Empty otherwise
     */
    public Optional<PersonDetails> loadUserByJwtToken(String jwtToken) {
        if (jwtProvider.isValidToken(jwtToken)) {
            return Optional.of(new PersonDetails(jwtProvider.getPersonId(jwtToken), jwtProvider.getUsername(jwtToken),
            jwtProvider.getRole(jwtToken),
                    Set.copyOf(jwtProvider.getAuthorities(jwtToken))));
        }
        return Optional.empty();
    }

}
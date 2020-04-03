package com.foodforcharity.app.service;

import java.util.Optional;
import java.util.Set;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.security.JwtProvider;
import com.foodforcharity.app.domain.security.PersonDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Service to associate user with password and roles setup in the database.
 *
 */
@Component
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    private final JwtProvider jwtProvider;

    @Autowired
    PersonDetailsService(PersonRepository personRepository, JwtProvider jwtProvider) {
        this.personRepository = personRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public PersonDetail loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with name %s does not exist", s)));

        return new PersonDetail(person);
    }

    /**
     * Extract the username from the JWT then lookup the user in the database.
     *
     * @param jwtToken
     * @return
     */
    public Optional<PersonDetail> loadUserByJwtTokenAndDatabase(String jwtToken) {
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
    public Optional<PersonDetail> loadUserByJwtToken(String jwtToken) {
        if (jwtProvider.isValidToken(jwtToken)) {
            return Optional.of(new PersonDetail(jwtProvider.getPersonId(jwtToken), jwtProvider.getUsername(jwtToken),
                    Set.copyOf(jwtProvider.getAuthorities(jwtToken))));
        }
        return Optional.empty();
    }

}
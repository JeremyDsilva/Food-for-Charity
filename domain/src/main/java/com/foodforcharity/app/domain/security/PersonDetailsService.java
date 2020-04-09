package com.foodforcharity.app.domain.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service to associate user with password and roles setup in the database.
 *
 */
@Service
public interface PersonDetailsService extends UserDetailsService {
   
    public PersonDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    public Optional<PersonDetails> loadUserByJwtTokenAndDatabase(String jwtToken);

    public Optional<PersonDetails> loadUserByJwtToken(String jwtToken);

}
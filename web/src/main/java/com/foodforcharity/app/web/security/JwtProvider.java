package com.foodforcharity.app.web.security;

import java.util.Optional;

import com.foodforcharity.app.domain.security.PersonDetails;

import org.springframework.stereotype.Component;

/**
 * Utility Class for common Java Web Token operations
 *
 */
@Component
public interface JwtProvider {

    /**
     * Create jwt token from persondetails 
     * 
     * @param personDetail
     * @return jwt token
     */
    public String createToken(PersonDetails personDetail);

    /**
     * 
     * @param jwtToken
     * @return
     */
    public Optional<PersonDetails> loadUserByToken(String jwtToken);

}
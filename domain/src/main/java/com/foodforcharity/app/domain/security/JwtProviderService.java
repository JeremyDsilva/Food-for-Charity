package com.foodforcharity.app.domain.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * Utility Class for common Java Web Token operations
 *
 */
@Service
public interface JwtProviderService {

    /**
     * Create jwt token from persondetails 
     * 
     * @param personDetail
     * @return jwt token
     */
    public String createToken(PersonDetails personDetail);

    /**
     * Validate the JWT String
     *
     * @param token JWT string
     * @return true if valid, false otherwise
     */
    public boolean isValidToken(String token);

    /**
     * Get the username from the token string
     *
     * @param token jwt
     * @return username
     */
    public String getUsername(String token);
    /**
     * Get the person id from the token string
     *
     * @param token jwt
     * @return person Id
     */
    public Long getPersonId(String token);

    /**
     * Get the person role from the token string
     *
     * @param token jwt
     * @return person role
     */
    public String getRole(String token) ;

    /**
     * Get the authorities from the token string
     *
     * @param token jwt
     * @return person authorities
     */
    public List<GrantedAuthority> getAuthorities(String token);


}
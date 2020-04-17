package com.foodforcharity.app.web.security;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import com.foodforcharity.app.domain.security.PersonDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Utility Class for common Java Web Token operations
 *
 */
@Component
public class JwtProviderImplementaion implements JwtProvider {

    private final String ID_KEY = "id";
    private final String ROLE_KEY = "role";
    private final String STATUS_KEY = "status";

    private final String secretKey;
    private final long validityInMilliseconds;

    @Autowired
    public JwtProviderImplementaion(@Value("${security.jwt.token.secret-key}") String secretKey,
            @Value("${security.jwt.token.expiration}") long validityInMilliseconds) {

        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.validityInMilliseconds = validityInMilliseconds;
    }

    /**
     * Create jwt token from persondetails
     * 
     * @param personDetail
     * @return jwt token
     */
    public String createToken(PersonDetails personDetail) { // List<Role> roles
        // Add the username to the payload
        Claims claims = Jwts.claims().setSubject(personDetail.getUsername());

        // Add Person ID
        claims.put(ID_KEY, personDetail.getPersonId());

        // Add Person Role
        claims.put(ROLE_KEY, personDetail.getRole());

        // Add Person Status
        claims.put(STATUS_KEY, personDetail.getStatus());

        // Build the Token
        Date now = new Date();
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    /**
     * Extract username and roles from a validated jwt string.
     *
     * @param jwtToken jwt string
     * @return UserDetails if valid, Empty otherwise
     */
    public Optional<PersonDetails> loadUserByToken(String jwtToken) {
        if (isValidToken(jwtToken)) {
            return Optional.of(new PersonDetails(getPersonId(jwtToken), getUsername(jwtToken), getRole(jwtToken),
                    getStatus(jwtToken)));
        }
        return Optional.empty();
    }

    /**
     * Validate the JWT String
     *
     * @param token JWT string
     * @return true if valid, false otherwise
     */
    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Get the username from the token string
     *
     * @param token jwt
     * @return username
     */
    public String getUsername(String token) {
        return extractClaim(token).getSubject();
    }

    /**
     * Get the person id from the token string
     *
     * @param token jwt
     * @return person Id
     */
    public Long getPersonId(String token) {
        return extractClaim(token, ID_KEY, Long.class);
    }

    /**
     * Get the person role from the token string
     *
     * @param token jwt
     * @return person role
     */
    public String getRole(String token) {
        return extractClaim(token, ROLE_KEY, String.class);
    }

    /**
     * Get the person status from the token string
     *
     * @param token jwt
     * @return person role
     */
    public String getStatus(String token) {
        return extractClaim(token, STATUS_KEY, String.class);
    }

    private <T> T extractClaim(String token, String key, Class<T> type) {
        return extractClaim(token).get(key, type);
    }

    private Claims extractClaim(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}
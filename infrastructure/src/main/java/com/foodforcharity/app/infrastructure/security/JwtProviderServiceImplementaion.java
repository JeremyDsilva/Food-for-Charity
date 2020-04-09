package com.foodforcharity.app.infrastructure.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.foodforcharity.app.domain.security.JwtProviderService;
import com.foodforcharity.app.domain.security.PersonDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

// import com.example.ec.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Utility Class for common Java Web Token operations
 *
 */
@Service
public class JwtProviderServiceImplementaion implements JwtProviderService {

    private final String ID_KEY = "id";
    private final String ROLE_KEY = "role";
    private final String AUTHORITY_KEY = "authority";

    private final String secretKey;
    private final long validityInMilliseconds;

    @Autowired
    public JwtProviderServiceImplementaion(@Value("${security.jwt.token.secret-key}") String secretKey,
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

        // Add Person ID
        claims.put(ROLE_KEY, personDetail.getRole().name());

        // Add to Simple Granted Authority objects to claims
        claims.put(AUTHORITY_KEY, personDetail.getAuthorities());

        // Build the Token
        Date now = new Date();
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
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
     * Get the authorities from the token string
     *
     * @param token jwt
     * @return person authorities
     */
    public List<GrantedAuthority> getAuthorities(String token) {
        List<Map<String, String>> authClaims = extractClaim(token, AUTHORITY_KEY, List.class);

        return authClaims.stream().map(authClaim -> new SimpleGrantedAuthority(authClaim.get("authority")))
                .collect(Collectors.toList());
    }

    private <T> T extractClaim(String token, String key, Class<T> type) {
        return extractClaim(token).get(key, type);
    }

    private Claims extractClaim(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}
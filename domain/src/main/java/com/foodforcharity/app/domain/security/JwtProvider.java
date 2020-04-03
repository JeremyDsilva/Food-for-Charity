package com.foodforcharity.app.domain.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

// import com.example.ec.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Utility Class for common Java Web Token operations
 *
 */
@Component
public class JwtProvider {

    private final String AUTHORITY_KEY = "authority";
    private final String ID_KEY = "id";

    private final String secretKey;
    private final long validityInMilliseconds;

    @Autowired
    public JwtProvider(@Value("${security.jwt.token.secret-key}") String secretKey,
            @Value("${security.jwt.token.expiration}") long validityInMilliseconds) {

        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public String createToken(PersonDetail personDetail) { // List<Role> roles
        // Add the username to the payload
        Claims claims = Jwts.claims().setSubject(personDetail.getUsername());

        // Add
        claims.put(ID_KEY, personDetail.getPersonId());

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
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public Long getPersonId(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get(ID_KEY, Long.class);
    }

    /**
     * Get the roles from the token string
     *
     * @param token jwt
     * @return username
     */
    public List<GrantedAuthority> getAuthorities(String token) {
        List<Map<String, String>> authClaims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get(AUTHORITY_KEY, List.class);

        return authClaims.stream().map(authClaim ->
                new SimpleGrantedAuthority(authClaim.get("authority")))
                .collect(Collectors.toList());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}
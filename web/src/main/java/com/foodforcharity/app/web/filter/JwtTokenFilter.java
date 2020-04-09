package com.foodforcharity.app.web.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.foodforcharity.app.domain.security.PersonDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Filter for Java Web Token Authentication and Authorization
 *
 */
public class JwtTokenFilter extends GenericFilterBean {
    private static final String BEARER = "Bearer";
    private String COOKIENAME = "accesstoken";

    private PersonDetailsService personDetailsService;

    @Autowired
    public JwtTokenFilter(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    /**
     * Determine if there is a JWT as part of the HTTP Request Header. If it is
     * valid then set the current context With the Authentication(user and roles)
     * found in the token
     *
     * @param req         Servlet Request
     * @param res         Servlet Response
     * @param filterChain Filter Chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // Check for Authorization:Bearer JWT
        getJwtFromCookie((HttpServletRequest) request).ifPresent(jwt -> getBearerToken(jwt).ifPresent(token ->
        // Pull the Username and Roles from the JWT to construct the user details
        personDetailsService.loadUserByJwtToken(token).ifPresent(userDetails -> {
            // Add the user details (Permissions) to the Context for just this API
            // invocation
            SecurityContextHolder.getContext().setAuthentication(
                    new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
        })));

        // move on to the next filter in the chains
        filterChain.doFilter(request, response);
    }

    private Optional<String> getJwtFromCookie(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (COOKIENAME.equals(cookie.getName())) {
                    String accessToken = cookie.getValue();
                    if (accessToken == null)
                        return Optional.empty();

                    return Optional.of(accessToken);
                }
            }
        } catch (Exception e) {

        }
        return Optional.empty();
    }

    /**
     * if present, extract the jwt token from the "Bearer <jwt>" header value.
     *
     * @param headerVal
     * @return jwt if present, empty otherwise
     */
    private Optional<String> getBearerToken(String headerVal) {
        if (headerVal != null) {
            return Optional.of(headerVal);
        }
        return Optional.empty();
    }

}
package com.foodforcharity.app.web.filter;

import com.foodforcharity.app.web.security.CookieUtil;
import com.foodforcharity.app.web.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter for Java Web Token Authentication and Authorization
 */
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;
    private final CookieUtil cookieUtil;

    @Autowired
    public JwtTokenFilter(CookieUtil cookieUtil, JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
        this.cookieUtil = cookieUtil;
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

        // Get JWT from cookie
        cookieUtil.getToken((HttpServletRequest) request).ifPresent(jwt ->
                // Pull the Username and Roles from the JWT to construct the user details
                jwtProvider.loadUserByToken(jwt).ifPresent(userDetails -> {
                    // Add the user details to SecurityContextHolder
                    SecurityContextHolder.getContext().setAuthentication(
                            new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
                }));

        // move on to the next filter in the chains
        filterChain.doFilter(request, response);
    }

}
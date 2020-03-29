package com.foodforcharity.app.usecase.account.login;

import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginCommandHandler implements CommandHandler<LoginCommand, String> {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    /**
     * @param authenticationManager
     */
    @Autowired
    public LoginCommandHandler(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public String handle(LoginCommand command)  {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                command.username,command.password));
        } catch (BadCredentialsException e) {
            // throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(command.username);

        final String jwt = jwtProvider.createToken(userDetails.getPassword());

        return jwt;
    }

}
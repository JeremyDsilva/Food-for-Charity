package com.foodforcharity.app.usecase.account.createjwt;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.security.JwtProviderService;
import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.domain.security.PersonDetailsService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class CreateJwtCommandHandler implements CommandHandler<CreateJwtCommand, Response<String>> {

    private final AuthenticationManager authenticationManager;
    private final PersonDetailsService personDetailsService;
    private final JwtProviderService jwtProvider;

    @Autowired
    public CreateJwtCommandHandler(AuthenticationManager authenticationManager,
            PersonDetailsService personDetailsService, JwtProviderService jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.personDetailsService = personDetailsService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Response<String> handle(CreateJwtCommand command) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(command.username, command.password));
        } catch (BadCredentialsException e) {
            return Response.of(Error.IncorrectUsernameOrPassword);
        }

        final PersonDetails personDetails = personDetailsService.loadUserByUsername(command.username);

        final String jwt = jwtProvider.createToken(personDetails);

        return Response.of(jwt);
    }

}
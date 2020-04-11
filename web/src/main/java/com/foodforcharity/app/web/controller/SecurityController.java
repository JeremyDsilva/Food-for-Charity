package com.foodforcharity.app.web.controller;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.createjwt.CreateJwtCommand;
import com.foodforcharity.app.web.model.AuthenticationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController extends AbstractController {

    @Autowired
    SecurityController(Mediator mediator) {
       super(mediator);
    }

    @GetMapping(value = "/login")
    public String getLoginView(Model model) {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletResponse response,
            @ModelAttribute AuthenticationRequest authenticationRequest, Model model) throws ExecutionException {

        CreateJwtCommand command = new CreateJwtCommand(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        Response<String> jwt = publishAsync(command).get();

        if (!jwt.success())
            return "login";

        response.setHeader(HttpHeaders.SET_COOKIE, ResponseCookie.from("accesstoken", jwt.getResponse())
                .maxAge(Duration.ofDays(10)).httpOnly(true).path("/").build().toString());

        
        return "redirect:/home";
    }

}
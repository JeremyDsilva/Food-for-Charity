package com.foodforcharity.app.web.controller;

import javax.servlet.http.HttpServletResponse;

import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.web.model.AuthenticationRequest;
import com.foodforcharity.app.web.security.CookieUtil;
import com.foodforcharity.app.web.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final CookieUtil cookieUtil;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    SecurityController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, CookieUtil cookieUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.cookieUtil = cookieUtil;
    }

    @GetMapping(value = "/login")
    public String getLoginView(Model model) {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletResponse response, @ModelAttribute AuthenticationRequest authenticationRequest,
            Model model) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            response.setHeader(HttpHeaders.SET_COOKIE, cookieUtil
                    .create(jwtProvider.createToken((PersonDetails) authentication.getPrincipal())).toString());

            return "redirect:/home";
        } catch (BadCredentialsException e) {
            return "redirect:login?error";
        }
    }

}
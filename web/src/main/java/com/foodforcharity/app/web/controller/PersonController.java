package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.login.LoginCommand;
import com.foodforcharity.app.web.model.AuthenticationRequest;
import com.foodforcharity.app.web.model.AuthenticationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class PersonController {

    Mediator mediator;

    @Autowired
    PersonController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/login")
    public String getLoginView(Model model) {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<AuthenticationResponse> getLoginView(
            @RequestBody AuthenticationRequest authenticationRequest) throws ExecutionException {

        LoginCommand command = new LoginCommand(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        String jwt = mediator.publishAsync(command).get();

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/changepassword")
    public String getChangePasswordView(Model model) {
        return "change-password";
    }

    @PostMapping("/changepassword")
    @ResponseBody
    public Boolean changePassword(Model model, @RequestParam(defaultValue = "password") String password,
            @RequestParam(defaultValue = "newPassword") String newPassword) throws ExecutionException {
        /*
         * Get person id from session
         */
        long personId = 1;

        ChangePasswordCommand command = new ChangePasswordCommand(personId, password, newPassword);

        Boolean isSuccessful = mediator.publishAsync(command).get();

        return isSuccessful;
    }

}
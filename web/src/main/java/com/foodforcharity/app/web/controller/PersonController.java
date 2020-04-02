package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.login.LoginCommand;
import com.foodforcharity.app.usecase.account.register.RegisterCommand;
import com.foodforcharity.app.web.model.AuthenticationRequest;
import com.foodforcharity.app.web.model.AuthenticationResponse;
import com.foodforcharity.app.web.model.RequestModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ResponseEntity<AuthenticationResponse> getLoginView(@RequestBody AuthenticationRequest authenticationRequest)
            throws ExecutionException {

        LoginCommand command = new LoginCommand(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        Response<String> jwt = mediator.publishAsync(command).get();

        return ResponseEntity.ok(new AuthenticationResponse(jwt.getResponse()));

    }

    @GetMapping("/changepassword")
    public String getChangePasswordView(Model model) {
        return "change-password";
    }

    @PostMapping("/changepassword")
    @ResponseBody
    public Boolean changePassword(Authentication authentication, Model model,
            @RequestParam(defaultValue = "password") String password,
            @RequestParam(defaultValue = "newPassword") String newPassword) throws ExecutionException {
        /*
         * Get person id from session
         */

        long personId = 1;

        ChangePasswordCommand command = new ChangePasswordCommand(personId, password, newPassword);

        Boolean isSuccessful =  mediator.publishAsync(command).get();

        return isSuccessful;
    }

    @GetMapping("/register")
    public String getRegisterView(Model model){
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RequestModel requestModel, Model model) throws ExecutionException{
        RegisterCommand command = new RegisterCommand(requestModel.getName(), requestModel.getPassword(),
            requestModel.getEmail(), requestModel.getPersonRole(), requestModel.getPhoneNumber(),
                requestModel.getCity(), requestModel.getCountry(), requestModel.getAddress());

       Response<Void> response = mediator.publishAsync(command).get();

        if(response.success()){
            return "login";
        }
        else model.addAttribute("id", response.getError().get(0).getMessage());
    }

}
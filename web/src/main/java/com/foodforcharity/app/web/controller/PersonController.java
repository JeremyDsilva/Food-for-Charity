package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.useraccount.register.RegisterCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PersonController {

    Mediator mediator;

    @Autowired
    PersonController(Mediator mediator) {
        this.mediator = mediator;
    }

    String registerPerson(Model model) throws InterruptedException, ExecutionException {
        RegisterCommand registerCommand = new RegisterCommand();
        Boolean isSuccessful = mediator.publish(registerCommand).get();      
        model.addAttribute("Sucess", isSuccessful);
        return "register-view";        
    }

}
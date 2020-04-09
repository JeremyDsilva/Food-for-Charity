package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.mediator.Mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/broker")
@PreAuthorize("Broker")
public class BrokerController extends AbstractController {

    @Autowired
    BrokerController(Mediator mediator) {
       super(mediator);
    }

    @GetMapping(value = "/home")
    public String getMethodName() {
        return "broker-home";
    }

}
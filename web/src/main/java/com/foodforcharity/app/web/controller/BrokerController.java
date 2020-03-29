package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.mediator.Mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/broker")
public class BrokerController {

    Mediator mediator;

    @Autowired
    BrokerController(Mediator mediator) {
        this.mediator = mediator;
    }

    
}
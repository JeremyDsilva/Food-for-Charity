package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.mediator.Mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donor")
public class DonorController {

    Mediator mediator;

    @Autowired
    DonorController(Mediator mediator) {
        this.mediator = mediator;
    }

   

}
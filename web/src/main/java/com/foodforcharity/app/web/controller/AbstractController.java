package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.mediator.Command;
import com.foodforcharity.app.mediator.Mediator;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {

    private final Mediator mediator;

    AbstractController(Mediator mediator){
        this.mediator = mediator;
    }

    final protected <Response> AsyncResult<Response> publishAsync(Command<Response> command) {
        return mediator.publishAsync(command);
    }

    final private PersonDetails getPersonDetails(){
        return (PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }   
    
    final protected long getPersonId(){
        return getPersonDetails().getPersonId();
    }   
    
    final String getPersonRole() {
        return getPersonDetails().getRole();
    }

}
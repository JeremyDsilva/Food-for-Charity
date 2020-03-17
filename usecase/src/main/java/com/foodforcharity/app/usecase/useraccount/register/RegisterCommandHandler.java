package com.foodforcharity.app.usecase.useraccount.register;

import java.util.concurrent.Future;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class RegisterCommandHandler implements CommandHandler<RegisterCommand, Boolean> {

    private final PersonRepository personRepository;

    @Autowired
    RegisterCommandHandler(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Future<Boolean> handle(RegisterCommand command) {

        return null;
    }
    
}
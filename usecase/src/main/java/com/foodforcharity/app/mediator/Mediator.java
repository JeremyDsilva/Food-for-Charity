package com.foodforcharity.app.mediator;

import java.util.Hashtable;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import com.foodforcharity.app.usecase.useraccount.register.RegisterCommand;
import com.foodforcharity.app.usecase.useraccount.register.RegisterCommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class Mediator {

    private Hashtable<Class<? extends Command<?>>, CommandHandler> commandHandlerMap;

    Mediator()
    {
        commandHandlerMap = new Hashtable<Class<? extends Command<?>>, CommandHandler>();
    }

    @PostConstruct
    @Autowired
    void init(RegisterCommandHandler registerCommandHandler){
        add(RegisterCommand.class, registerCommandHandler);
    }

	private <R> Boolean add(Class<? extends Command<R>> command, CommandHandler<? extends Command<R>, R> commandHandler) {
		return commandHandlerMap.putIfAbsent(command, commandHandler) == null;
	}

    @Async
    public <Response> Future<Response> publishAsync(Command<Response> command){
        return commandHandlerMap.get(command.getClass()).handle(command);
    }

    public <Response> Future<Response> publish(Command<Response> command){
        return commandHandlerMap.get(command.getClass()).handle(command);
    }


}
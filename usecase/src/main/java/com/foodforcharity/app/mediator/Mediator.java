package com.foodforcharity.app.mediator;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import com.foodforcharity.app.usecase.useraccount.register.RegisterCommand;
import com.foodforcharity.app.usecase.useraccount.register.RegisterCommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class Mediator {

    private Hashtable<Class<? extends Command<?>>, CommandHandler> commandHandlerMap;
    private ExecutorService executor;

    Mediator() {
        commandHandlerMap = new Hashtable<Class<? extends Command<?>>, CommandHandler>();
        this.executor = Executors.newSingleThreadExecutor();
    }

    @PostConstruct
    @Autowired
    void init(RegisterCommandHandler registerCommandHandler) {
        add(RegisterCommand.class, registerCommandHandler);
    }

    private <R> Boolean add(Class<? extends Command<R>> command,
            CommandHandler<? extends Command<R>, R> commandHandler) {
        return commandHandlerMap.putIfAbsent(command, commandHandler) == null;
    }

    @Async
    public <Response> Future<Response> publishAsync(Command<Response> command) {
        return executor.submit(() -> {
            return publish(command);
        });
    }

    public <Response> Response publish(Command<Response> command) {
        return ((CommandHandler<Command<Response>, Response>) commandHandlerMap.get(command.getClass())).handle(command);
    }

}
package com.foodforcharity.app.mediator;

import java.util.Hashtable;

import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.foodforcharity.app.usecase" })
public class MediatorConfigration {

    
    private final MediatorImplementation mediator;

    @Autowired
    MediatorConfigration() {
        mediator = new MediatorImplementation();
    }

    @Bean
    public Mediator createMediator() {

        return mediator;
    }

    private class MediatorImplementation implements Mediator {

        private Hashtable<Class<? extends Command<?>>, CommandHandler> commandHandlerMap;

        MediatorImplementation() {
            commandHandlerMap = new Hashtable<Class<? extends Command<?>>, CommandHandler>();
        }

        private <R> Boolean add(Class<? extends Command<R>> command,
                CommandHandler<? extends Command<R>, R> commandHandler) {
            return commandHandlerMap.putIfAbsent(command, commandHandler) == null;
        }

        public <Response> Response publish(Command<Response> command) {
            return ((CommandHandler<Command<Response>, Response>) commandHandlerMap.get(command.getClass()))
                    .handle(command);
        }

    }

}
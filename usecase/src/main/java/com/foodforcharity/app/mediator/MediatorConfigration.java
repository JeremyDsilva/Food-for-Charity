package com.foodforcharity.app.mediator;

import java.util.Hashtable;

import com.foodforcharity.app.usecase.account.changepassword.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.foodforcharity.app.usecase" })
public class MediatorConfigration {

    CommandHandler<ChangePasswordCommand, Boolean> changePasswordCommandHandler;
    
    private final MediatorImplementation mediator;

    @Autowired
    MediatorConfigration(CommandHandler<ChangePasswordCommand, Boolean> changePasswordCommandHandler) {
        mediator = new MediatorImplementation();
        this.changePasswordCommandHandler = changePasswordCommandHandler;
    }

    @Bean
    public Mediator createMediator() {
        mediator.add(ChangePasswordCommand.class, changePasswordCommandHandler);       

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
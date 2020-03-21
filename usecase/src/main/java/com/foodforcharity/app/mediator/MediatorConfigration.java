package com.foodforcharity.app.mediator;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.foodforcharity.app.usecase.useraccount.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.useraccount.changepassword.ChangePasswordCommandHandler;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.foodforcharity.app.usecase" })
public class MediatorConfigration {

    CommandHandler<ChangePasswordCommand, Boolean> changePasswordCommandHandler;

    @Autowired
    MediatorConfigration(CommandHandler<ChangePasswordCommand, Boolean> changePasswordCommandHandler) {
        this.changePasswordCommandHandler = changePasswordCommandHandler;
    }

    @Bean
    public Mediator createMediator() {
        MediatorImplementation mediator = new MediatorImplementation();
        mediator.add(ChangePasswordCommand.class, changePasswordCommandHandler);

        return mediator;
    }

    private class MediatorImplementation implements Mediator {

        private Hashtable<Class<? extends Command<?>>, CommandHandler> commandHandlerMap;
        private ExecutorService executor;

        @Autowired
        MediatorImplementation() {
            commandHandlerMap = new Hashtable<Class<? extends Command<?>>, CommandHandler>();
            this.executor = Executors.newSingleThreadExecutor();
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
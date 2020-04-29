package com.foodforcharity.app.mediator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

public class MediatorImplementation implements Mediator {

    private Hashtable<Class<? extends Command<?>>, CommandHandler> commandHandlerMap;

    public MediatorImplementation(List<CommandHandler<?, ?>> handlers) {
        commandHandlerMap = new Hashtable<Class<? extends Command<?>>, CommandHandler>();

        for (CommandHandler<?, ?> handler : handlers) {
            ParameterizedType parameterizedType = null;

            Class<?> clazz = handler.getClass();
            while(parameterizedType == null){
                Type interfaces[] = clazz.getInterfaces();
                for(int i = 0; i < interfaces.length; ++i){
                    if(interfaces[i] == com.foodforcharity.app.mediator.CommandHandler.class){
                        parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[i];
                        break;
                    }
                }
                clazz = clazz.getSuperclass();
            }

            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            Class<? extends Command<?>> command = (Class<? extends Command<?>>) typeArguments[0];
            add(command, handler);
        }
    }

    private <R> Boolean add(Class<? extends Command<?>> typeArgument, CommandHandler<?, ?> handler) {
        return commandHandlerMap.putIfAbsent(typeArgument, handler) == null;
    }

    public <Response> Response publish(Command<Response> command) {
        return ((CommandHandler<Command<Response>, Response>) commandHandlerMap.get(command.getClass()))
                .handle(command);
    }

}
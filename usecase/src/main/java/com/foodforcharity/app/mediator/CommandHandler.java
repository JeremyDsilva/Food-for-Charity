package com.foodforcharity.app.mediator;

public interface CommandHandler<C extends Command<Response>, Response> {

    public abstract Response handle(C command);

}
package com.foodforcharity.app.mediator;

import org.springframework.stereotype.Service;

@Service
public interface CommandHandler<C extends Command<Response>, Response> {

    public Response handle(C command);

}
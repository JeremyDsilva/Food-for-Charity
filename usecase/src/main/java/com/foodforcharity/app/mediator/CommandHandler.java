package com.foodforcharity.app.mediator;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;

public interface CommandHandler<C extends Command<Response>, Response> {

    @Async
    public abstract Future<Response> handle(C command);

}
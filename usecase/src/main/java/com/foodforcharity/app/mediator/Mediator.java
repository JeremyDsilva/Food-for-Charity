package com.foodforcharity.app.mediator;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public interface Mediator {

    @Async
    default <Response> AsyncResult<Response> publishAsync(Command<Response> command) {
        return new AsyncResult<Response>(publish(command));
    }

    public <Response> Response publish(Command<Response> command);

}
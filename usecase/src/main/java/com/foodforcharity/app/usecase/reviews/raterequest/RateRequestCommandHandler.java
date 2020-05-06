package com.foodforcharity.app.usecase.reviews.raterequest;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class RateRequestCommandHandler implements CommandHandler<RateRequestCommand, Response<Void>> {

    @Override
    public Response<Void> handle(RateRequestCommand command) {

        return null;

    }

}
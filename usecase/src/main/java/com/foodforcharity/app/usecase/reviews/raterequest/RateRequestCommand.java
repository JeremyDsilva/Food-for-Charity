package com.foodforcharity.app.usecase.reviews.raterequest;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class RateRequestCommand implements Command<Response<Void>> {
    long personId; // id of the filer
    long requestId;
    long rating;
}
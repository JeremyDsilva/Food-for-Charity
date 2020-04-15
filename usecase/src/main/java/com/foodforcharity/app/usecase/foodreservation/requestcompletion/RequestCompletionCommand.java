package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Value;

@Value
public class RequestCompletionCommand implements Command< Response<Void>> {
	long donorId;
	long requestId;

}
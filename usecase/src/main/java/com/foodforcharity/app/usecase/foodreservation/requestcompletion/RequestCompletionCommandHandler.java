package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import com.foodforcharity.app.mediator.CommandHandler;


import org.springframework.stereotype.Service;

@Service
public class RequestCompletionCommandHandler implements CommandHandler<RequestCompletionCommand, Void> {
	

	public RequestCompletionCommandHandler() {

	}
	
	@Override
	public Void handle(RequestCompletionCommand command) {
		

		return null;

	}
}
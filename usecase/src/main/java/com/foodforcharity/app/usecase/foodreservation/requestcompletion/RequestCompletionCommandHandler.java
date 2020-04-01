package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import com.foodforcharity.app.mediator.CommandHandler;


import org.springframework.stereotype.Service;

@Service
public class RequestCompletionCommandHandler implements CommandHandler<RequestCompletionCommand, Void> {
	

	public RequestCompletionCommandHandler() {
		//1- check that request exists and is in active 
		// check that donor id matches request donor id
		// reset the request status
	}
	
	@Override
	public Void handle(RequestCompletionCommand command) {
		

		return null;

	}
}
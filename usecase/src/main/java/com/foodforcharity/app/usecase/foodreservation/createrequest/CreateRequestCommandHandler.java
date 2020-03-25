package com.foodforcharity.app.usecase.foodreservation.createrequest;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class CreateRequestCommandHandler implements CommandHandler<CreateRequestCommand, Void> {

	public CreateRequestCommandHandler(){

	}

	@Override
	public Void handle(CreateRequestCommand command) {

		return null;

	}

}
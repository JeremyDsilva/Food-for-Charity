package com.foodforcharity.app.usecase.account.register;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class RegisterCommandHandler implements CommandHandler<RegisterCommand, Void> {

	public RegisterCommandHandler(){

	}

	@Override
	public Void handle(RegisterCommand command) {

		return null;

	}

}
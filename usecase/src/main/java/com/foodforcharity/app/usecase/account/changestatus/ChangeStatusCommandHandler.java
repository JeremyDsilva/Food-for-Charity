package com.foodforcharity.app.usecase.account.changestatus;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class ChangeStatusCommandHandler implements CommandHandler<ChangeStatusCommand, Void> {

	public ChangeStatusCommandHandler(){

	}

	@Override
	public Void handle(ChangeStatusCommand command) {

		return null;

	}

}
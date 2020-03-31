package com.foodforcharity.app.usecase.account.register;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class RegisterCommandHandler implements CommandHandler<RegisterCommand, Response<Void>> {

	public RegisterCommandHandler(){

	}

	@Override
	public Response<Void> handle(RegisterCommand command) {




		return null;

	}

}
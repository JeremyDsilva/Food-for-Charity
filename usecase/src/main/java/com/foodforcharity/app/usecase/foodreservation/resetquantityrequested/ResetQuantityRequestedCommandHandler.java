package com.foodforcharity.app.usecase.foodreservation.resetquantityrequested;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetQuantityRequestedCommandHandler implements CommandHandler<ResetQuantityRequestedCommand,Response<Void>>{

	@Autowired
	public ResetQuantityRequestedCommandHandler(){

	}

	
	public Response<Void> handle(ResetQuantityRequestedCommand command) {

		return null;

	}

}
package com.foodforcharity.app.usecase.profile.deletemenuitem;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class DeleteMenuItemCommandHandler implements CommandHandler<DeleteMenuItemCommand, Void> {

	public DeleteMenuItemCommandHandler(){

	}

	@Override
	public Void handle(DeleteMenuItemCommand command) {

		return null;

	}

}
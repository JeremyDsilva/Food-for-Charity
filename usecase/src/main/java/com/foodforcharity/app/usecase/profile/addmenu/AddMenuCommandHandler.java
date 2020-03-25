package com.foodforcharity.app.usecase.profile.addmenu;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class AddMenuCommandHandler implements CommandHandler<AddMenuCommand, Void> {

	public AddMenuCommandHandler(){

	}

	@Override
	public Void handle(AddMenuCommand command) {

		return null;

	}

}
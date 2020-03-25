package com.foodforcharity.app.usecase.profile.modifymenuitem;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class ModifyMenuItemCommandHandler implements CommandHandler<ModifyMenuItemCommand, Void> {

	public ModifyMenuItemCommandHandler(){

	}

	@Override
	public Void handle(ModifyMenuItemCommand command) {

		return null;

	}

}
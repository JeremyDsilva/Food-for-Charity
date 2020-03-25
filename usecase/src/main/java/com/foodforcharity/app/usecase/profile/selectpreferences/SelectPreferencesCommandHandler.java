package com.foodforcharity.app.usecase.profile.selectpreferences;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class SelectPreferencesCommandHandler implements CommandHandler<SelectPreferencesCommand, Void> {

	public SelectPreferencesCommandHandler(){

	}

	@Override
	public Void handle(SelectPreferencesCommand command) {

		return null;

	}

}
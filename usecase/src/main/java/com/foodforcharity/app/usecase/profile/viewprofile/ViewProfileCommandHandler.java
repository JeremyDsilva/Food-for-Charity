package com.foodforcharity.app.usecase.profile.viewprofile;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class ViewProfileCommandHandler implements CommandHandler<ViewProfileCommand, Void> {

	public ViewProfileCommandHandler(){

	}

	@Override
	public Void handle(ViewProfileCommand command) {

		return null;

	}

}
package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class ViewComplaintCommandHandler implements CommandHandler<ViewComplaintCommand, Void> {

	public ViewComplaintCommandHandler() {

	}

	@Override
	public Void handle(ViewComplaintCommand command) {

		return null;

	}

}
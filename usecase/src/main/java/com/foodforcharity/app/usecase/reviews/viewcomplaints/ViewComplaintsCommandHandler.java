package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

@Service
public class ViewComplaintsCommandHandler implements CommandHandler<ViewComplaintsCommand, Void> {

	public ViewComplaintsCommandHandler(){

	}

	@Override
	public Void handle(ViewComplaintsCommand command) {

		return null;

	}

}
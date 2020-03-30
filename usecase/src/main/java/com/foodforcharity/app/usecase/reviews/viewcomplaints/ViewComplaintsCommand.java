package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import com.foodforcharity.app.mediator.Command;

public class ViewComplaintsCommand implements Command<Void> {
	long PersonId; // required to decide which complaints to show based on who the person is

	public ViewComplaintsCommand() {

	}

	/**
	 * Public constructors
	 * 
	 * @param personId
	 */
	public ViewComplaintsCommand(long personId) {
		PersonId = personId;
	}

}
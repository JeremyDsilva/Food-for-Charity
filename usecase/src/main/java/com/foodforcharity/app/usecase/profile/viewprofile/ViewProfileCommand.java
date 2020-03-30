package com.foodforcharity.app.usecase.profile.viewprofile;

import com.foodforcharity.app.mediator.Command;

public class ViewProfileCommand implements Command<Void> {
	long personId;

	public ViewProfileCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param personId
	 */
	public ViewProfileCommand(long personId) {
		this.personId = personId;
	}

}
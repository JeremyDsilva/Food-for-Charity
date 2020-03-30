package com.foodforcharity.app.usecase.profile.deletemenuitem;

import com.foodforcharity.app.mediator.Command;

public class DeleteMenuItemCommand implements Command<Void> {
	long foodId;
	long donorId;

	public DeleteMenuItemCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param foodId
	 * @param donorId
	 */
	public DeleteMenuItemCommand(long foodId, long donorId) {
		this.foodId = foodId;
		this.donorId = donorId;
	}

}
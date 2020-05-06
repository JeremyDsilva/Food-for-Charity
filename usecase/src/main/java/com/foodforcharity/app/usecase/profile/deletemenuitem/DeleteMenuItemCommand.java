package com.foodforcharity.app.usecase.profile.deletemenuitem;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;

public class DeleteMenuItemCommand implements Command<Response<Void>> {
	long donorId;
	long foodId;

	public DeleteMenuItemCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param foodId
	 * @param donorId
	 */
	public DeleteMenuItemCommand(long donorId, long foodId) {
		this.donorId = donorId;
		this.foodId = foodId;
	}

}
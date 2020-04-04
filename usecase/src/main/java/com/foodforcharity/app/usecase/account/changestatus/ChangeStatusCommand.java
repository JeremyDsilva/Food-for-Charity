package com.foodforcharity.app.usecase.account.changestatus;

import com.foodforcharity.app.mediator.Command;

public class ChangeStatusCommand implements Command<Void> {
	long statusId; // the id of the new status
	long personId; // the person whose status needs to be changed

	public ChangeStatusCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param brokerId
	 * @param statusId
	 * @param personId
	 */
	public ChangeStatusCommand(long brokerId, long statusId, long personId) {
		this.statusId = statusId;
		this.personId = personId;
	}

}
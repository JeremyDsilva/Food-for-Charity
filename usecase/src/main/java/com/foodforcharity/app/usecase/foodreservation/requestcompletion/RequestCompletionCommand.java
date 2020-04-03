package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class RequestCompletionCommand implements Command< Response<Void>> {
	long donorId;
	long requestId;

	public RequestCompletionCommand() {

	
	}

	/**
	 * Public Constructor
	 * 
	 * @param donorId
	 * @param requestId
	 */
	public RequestCompletionCommand(long donorId, long requestId) {
		this.donorId = donorId;
		this.requestId = requestId;
	}

}
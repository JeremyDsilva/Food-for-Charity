package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import com.foodforcharity.app.mediator.Command;

public class ViewComplaintCommand implements Command<Void> {
	long PersonId;
	long compaintId;

	public ViewComplaintCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param personId
	 * @param compaintId
	 */
	public ViewComplaintCommand(long personId, long compaintId) {
		PersonId = personId;
		this.compaintId = compaintId;
	}

}
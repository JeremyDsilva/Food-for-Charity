package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class ViewComplaintCommand implements Command<Response<Complaint>> {
	long personId;
	long complaintId;

	public ViewComplaintCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param personId
	 * @param compaintId
	 */
	public ViewComplaintCommand(long personId, long complaintId) {
		this.personId = personId;
		this.complaintId = complaintId;
	}

}
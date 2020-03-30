package com.foodforcharity.app.usecase.reviews.filecomplaint;

import com.foodforcharity.app.mediator.Command;

public class FileComplaintCommand implements Command<Void> {
	long personId; // id of the filer
	long requestId;
	String descriptionText;

	public FileComplaintCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param personId
	 * @param requestId
	 * @param descriptionText
	 */
	public FileComplaintCommand(long personId, long requestId, String descriptionText) {
		this.personId = personId;
		this.requestId = requestId;
		this.descriptionText = descriptionText;
	}

}
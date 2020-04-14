package com.foodforcharity.app.usecase.profile.getdonor;

import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Getter;

@Getter
public class GetDonorCommand implements Command<Response<Donor>> {
	long personId;

	/**
	 * Public Constructor
	 * 
	 * @param personId
	 */
	public GetDonorCommand(long personId) {
		this.personId = personId;
	}

}
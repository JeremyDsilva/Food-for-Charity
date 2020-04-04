package com.foodforcharity.app.usecase.account.changestatus;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class ChangeStatusCommand implements Command<Response<Void>> {
	Optional<DonorStatus> donorStatus;
	Optional<DoneeStatus> doneeStatus;
	long personId; // the person whose status needs to be changed

	public ChangeStatusCommand() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param donorStatus
	 * @param doneeStatus
	 * @param personId
	 */
	public ChangeStatusCommand(long personId) {
		this.donorStatus = Optional.empty();
		this.doneeStatus = Optional.empty();
		this.personId = personId;
	}

	/**
	 * 
	 * @return
	 */
	public Optional<DonorStatus> getDonorStatus() {
		return donorStatus;
	}

	/**
	 * 
	 * @param donorStatus
	 */
	public void setDonorStatus(DonorStatus donorStatus) {
		this.donorStatus = Optional.of(donorStatus);
	}

	/**
	 * 
	 * @return
	 */
	public Optional<DoneeStatus> getDoneeStatus() {
		return doneeStatus;
	}

	/**
	 * 
	 * @param doneeStatus
	 */
	public void setDoneeStatus(DoneeStatus doneeStatus) {
		this.doneeStatus = Optional.of(doneeStatus);
	}

}
package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.ComplaintRepository;
import com.foodforcharity.app.service.RequestRepository;

import org.springframework.stereotype.Service;

@Service
public class RequestCompletionCommandHandler implements CommandHandler<RequestCompletionCommand, Response<Void>> {
	ComplaintRepository complaintRepository;
	RequestRepository requestRepository;

	public RequestCompletionCommandHandler() {

	}

	/**
	 * Public Constructor
	 * 
	 * @param complaintRepository
	 * @param requestRepository
	 */
	public RequestCompletionCommandHandler(ComplaintRepository complaintRepository,
			RequestRepository requestRepository) {
		this.complaintRepository = complaintRepository;
		this.requestRepository = requestRepository;
	}

	@Override
	public Response<Void> handle(RequestCompletionCommand command) {
		Response<Void> response;
		// 1- check that request exists and is in active
		response = checkRequestExistsActive(command.requestId);
		if (!response.errors.isEmpty()) {
			return response;
		}
		Request request = requestRepository.findById(command.requestId).get();

		// 2-check that donor id matches request donor id and donor is active
		response = checkDonorAuthenticEligibility(request.getDonor(), command.donorId);
		if (!response.errors.isEmpty()) {
			return response;
		}

		// 3-reset the request status and save request
		request.setIsActive(false);
		requestRepository.save(request);

		return Response.EmptyResponse();

	}

	private Response<Void> checkDonorAuthenticEligibility(Donor donor, long donorId) {

		if (donor.getId() != donorId) {
			return Response.of(Error.DonorRequestDontMatch);
		}
		if (donor.getDonorStatus() != DonorStatus.Active || donor.getDonorStatus() != DonorStatus.Inactive) {
			return Response.of(Error.IneligibleDonorStatus);
		}
		return Response.EmptyResponse();
	}

	private Response<Void> checkRequestExistsActive(long requestId) {
		Optional<Request> dbRequest = requestRepository.findById(requestId);
		if (dbRequest.isEmpty()) {
			return Response.of(Error.RequestDoesNotExist);
		}
		Request request = dbRequest.get();
		if (!request.getIsActive()) {
			return Response.of(Error.InactiveRequest);
		}
		return Response.EmptyResponse();
	}

}

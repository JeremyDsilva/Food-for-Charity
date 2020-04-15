package com.foodforcharity.app.usecase.foodreservation.requestcompletion;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.RequestService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestCompletionCommandHandler implements CommandHandler<RequestCompletionCommand, Response<Void>> {
	RequestService requestService;

	/**
	 * Public Constructor
	 * 
	 * @param requestService
	 */
	@Autowired
	public RequestCompletionCommandHandler(RequestService requestService) {
		this.requestService = requestService;
	}

	@Override
	public Response<Void> handle(RequestCompletionCommand command) {

		try {
			// check that request exists
			Optional<Request> dbRequest = requestService.findById(command.getRequestId());
			if (dbRequest.isEmpty()) {
				return Response.of(Error.RequestDoesNotExist);
			}
			Request request = dbRequest.get();

			// check that request is active
			if (!request.getIsActive()) {
				return Response.of(Error.InactiveRequest);
			}

			// check that request belongs to donor
			if (request.getDonor().getId() != command.getDonorId()) {
				return Response.of(Error.DonorRequestDontMatch);
			}

			// Update request and save
			request.setIsActive(false);
			requestService.save(request);

			return Response.EmptyResponse();
		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}

	}

}

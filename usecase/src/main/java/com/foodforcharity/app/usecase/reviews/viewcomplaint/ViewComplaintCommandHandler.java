package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.ComplaintRepository;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewComplaintCommandHandler implements CommandHandler<ViewComplaintCommand, Response<Complaint>> {
	ComplaintRepository complaintRepository;
	

	/**
	 * Public Constructor
	 * 
	 * @param complaintRepository
	 */
	@Autowired
	public ViewComplaintCommandHandler(ComplaintRepository complaintRepository) {
		this.complaintRepository = complaintRepository;

	}

	@Override
	public Response<Complaint> handle(ViewComplaintCommand command) {

		try {
			Optional<Complaint> dbComplaint = complaintRepository.findById(command.complaintId);

			if (dbComplaint.isEmpty()) {
				return Response.of(Error.ComplaintDoesNotExist);
			}

			Complaint complaint = dbComplaint.get();
			Request request = complaint.getRequest();

			if (complaint.getFromDonee() && request.getDonee().getId() == command.personId) {
				return Response.of(complaint);
			} else if (!complaint.getFromDonee() && request.getDonor().getId() == command.personId) {
				return Response.of(complaint);
			} else {
				return Response.of(Error.ComplaintDoesNotExist);
			}
		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}

	}

}

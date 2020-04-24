package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.ComplaintService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViewComplaintCommandHandler implements CommandHandler<ViewComplaintCommand, Response<Complaint>> {
    ComplaintService complaintService;


    /**
     * Public Constructor
     *
     * @param complaintService
     */
    @Autowired
    public ViewComplaintCommandHandler(ComplaintService complaintService) {
        this.complaintService = complaintService;

    }

    @Override
    public Response<Complaint> handle(ViewComplaintCommand command) {

        try {
            Optional<Complaint> dbComplaint = complaintService.findById(command.getComplaintId());

            if (dbComplaint.isEmpty()) {
                return Response.of(Error.ComplaintDoesNotExist);
            }

            Complaint complaint = dbComplaint.get();
            Request request = complaint.getRequest();

            if (complaint.getFromDonee() && request.getDonee().getId() == command.getPersonId()) {
                return Response.of(complaint);
            } else if (!complaint.getFromDonee() && request.getDonor().getId() == command.getPersonId()) {
                return Response.of(complaint);
            } else {
                return Response.of(Error.ComplaintDoesNotExist);
            }
        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }

    }

}

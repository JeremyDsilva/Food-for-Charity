package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.ComplaintService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewComplaintsCommandHandler implements CommandHandler<ViewComplaintsCommand, Response<List<Complaint>>> {

    ComplaintService service;

    @Autowired
    public ViewComplaintsCommandHandler(ComplaintService service) {
        this.service = service;
    }

    @Override
    public Response<List<Complaint>> handle(ViewComplaintsCommand command) {

        if(command.getIsActive() != null && command.getFromRole() != null){
            if(command.getFromRole() == PersonRole.Broker)
                return null;
            service.findAllByFromDoneeAndIsActive(command.getFromRole() == PersonRole.Donee, command.getIsActive());
        }


        return null;
    }

}
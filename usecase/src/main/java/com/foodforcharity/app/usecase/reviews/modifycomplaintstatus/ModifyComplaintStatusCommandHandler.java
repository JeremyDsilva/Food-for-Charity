package com.foodforcharity.app.usecase.reviews.modifycomplaintstatus;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class ModifyComplaintStatusCommandHandler implements CommandHandler<ModifyComplaintStatusCommand, Response<Void>> {

    @Override
    public Response<Void> handle(ModifyComplaintStatusCommand command) {

        return null;

    }

}
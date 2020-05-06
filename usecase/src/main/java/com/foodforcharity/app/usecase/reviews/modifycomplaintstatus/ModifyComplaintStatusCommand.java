package com.foodforcharity.app.usecase.reviews.modifycomplaintstatus;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class ModifyComplaintStatusCommand implements Command<Response<Void>> {
    long complaintId;
    boolean isActive;
}
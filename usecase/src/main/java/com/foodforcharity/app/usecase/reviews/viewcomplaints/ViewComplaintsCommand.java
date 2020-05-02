package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Builder
@Getter
public class ViewComplaintsCommand implements Command<Response<List<Complaint>>> {

    Long personId;

    PersonRole fromRole;

    Boolean isActive;
}
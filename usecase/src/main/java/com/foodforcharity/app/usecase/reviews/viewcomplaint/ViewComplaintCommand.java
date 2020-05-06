package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class ViewComplaintCommand implements Command<Response<Complaint>> {
    long personId;
    long complaintId;

}
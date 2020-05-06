package com.foodforcharity.app.usecase.reviews.filecomplaint;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class FileComplaintCommand implements Command<Response<Void>> {
    long personId; // id of the filer
    long requestId;
    String descriptionText;

}
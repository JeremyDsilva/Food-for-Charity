package com.foodforcharity.app.usecase.foodreservation.resetquantityrequested;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Value;

@Value
public class ResetQuantityRequestedCommand implements Command<Response<Void>> {

}
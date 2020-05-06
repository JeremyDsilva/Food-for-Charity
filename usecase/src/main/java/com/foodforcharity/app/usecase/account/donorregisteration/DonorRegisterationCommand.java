package com.foodforcharity.app.usecase.account.donorregisteration;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class DonorRegisterationCommand implements Command<Response<Void>> {
    String name;
    String password;
    String email;
    String phoneNumber;
    String city;
    String address;
    String country;
}
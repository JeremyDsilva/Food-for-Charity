package com.foodforcharity.app.usecase.account.doneeregisteration;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class DoneeRegisterationCommand implements Command<Response<Void>> {
    String name;
    String password;
    String email;
    String phoneNumber;
    String city;
    String address;
    String country;
    DoneeType doneeType;
    Integer memberCount;

}
package com.foodforcharity.app.web.model;

import com.foodforcharity.app.domain.constant.DoneeType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DoneeRegisterRequest extends RegisterRequest {

    @NotNull(message = "Please choose type")
    DoneeType doneeType;

    @Min(value = 1)
    Integer numberOfMembers;

}
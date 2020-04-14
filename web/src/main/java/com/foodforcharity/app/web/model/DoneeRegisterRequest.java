package com.foodforcharity.app.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.constant.DoneeType;

import lombok.Data;

@Data
public class DoneeRegisterRequest extends RegisterRequest {

    @NotNull
    DoneeType doneeType;

    @Min(value = 1)
    Integer numberOfMembers;

}
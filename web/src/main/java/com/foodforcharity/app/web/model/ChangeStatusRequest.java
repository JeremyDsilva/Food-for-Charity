package com.foodforcharity.app.web.model;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangeStatusRequest {

    @NotNull
    Long personId;

    DoneeStatus doneeStatus;

    DonorStatus donorStatus;

}

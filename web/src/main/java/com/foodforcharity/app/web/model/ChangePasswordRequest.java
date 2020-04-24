package com.foodforcharity.app.web.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequest extends Request {

    @NotBlank
    String password;

    @NotBlank
    String newPassword;

    @NotBlank
    String confirmNewPassword;

}
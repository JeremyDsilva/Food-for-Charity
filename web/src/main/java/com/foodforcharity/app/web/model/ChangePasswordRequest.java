package com.foodforcharity.app.web.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ChangePasswordRequest extends Request {

    @NotBlank
    String password;

    @NotBlank
    String newPassword;

    @NotBlank
    String confirmNewPassword;

}
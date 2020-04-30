package com.foodforcharity.app.web.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequest extends Request {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotBlank
    String password;

    @NotBlank
    String newPassword;

    @NotBlank
    String confirmNewPassword;

}
package com.foodforcharity.app.web.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public abstract class RegisterRequest extends Request {

    @NotBlank
    private String name;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    // @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    @NotBlank
    private String address;
    
    @NotBlank
    private String city;

    @NotBlank
    private String country;
    
}
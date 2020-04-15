package com.foodforcharity.app.web.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public abstract class RegisterRequest extends Request {

    @NotBlank(message = "Please enter full name")
    private String name;

    @NotBlank
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 charcters")
    private String password;
    
    @NotBlank
    private String confirmPassword;
    
    @NotNull(message = "Email cannot be empty")
    @Email
    private String email;
    
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Phone number should be digits")
    @NotBlank
    private String phoneNumber;
    
    @NotBlank(message = "Country should be selected")
    private String country;
    
    @NotBlank(message = "City should be selected")
    private String city;
    
    @NotBlank(message = "Address cannot be empty")
    private String address;

    
}
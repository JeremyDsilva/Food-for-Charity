package com.foodforcharity.app.web.model;

import java.io.Serializable;

import com.foodforcharity.app.domain.constant.PersonRole;

import lombok.Data;

@Data
public class RegisterRequest implements Serializable {

    private PersonRole personRole;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    
}
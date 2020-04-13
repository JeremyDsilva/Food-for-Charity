package com.foodforcharity.app.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDetails implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Please enter your name or restaurant name")
    private String name;

    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 charcters")
    private String password;
    
    @Email(message = "Email cannot be empty")
    private String email;
    
    @NotNull(message = "This option cannot be empty")
    private String personRole;
    
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Phone number should be digits")
    @NotNull(message = "Phone Number cannot be empty")
    private String phoneNumber;
    
    @NotNull(message = "Country should be selected")
    private String country;
    
    @NotNull(message = "City should be selected")
    private String city;
    
    @NotNull(message = "Address cannot be empty")
    private String address;

    public UserDetails(){

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
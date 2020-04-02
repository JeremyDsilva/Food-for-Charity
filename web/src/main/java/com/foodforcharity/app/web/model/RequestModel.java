package com.foodforcharity.app.web.model;

import java.io.Serializable;

import com.foodforcharity.app.domain.constant.PersonRole;


public class RequestModel implements Serializable {


    private String name;
    private String password;
    private String email;
    private String personRole;
    private String phoneNumber;
    private String country;


    private String city;
    private String address;

    public RequestModel(){

    }

    public String getName() {
        return this.name;
    }

    public void setUsername(String name) {
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

    public PersonRole getPersonRole() {
        return PersonRole.valueOf(personRole);
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
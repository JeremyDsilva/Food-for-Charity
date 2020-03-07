package com.foodforcharity.security.app.domain;

/**
 * @author Frank P. Moley III.
 */
public class GuestModel {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String country;
    private String state;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Guest translateModelToGuest(){
        Guest guest = new Guest();
        guest.setFirstName(this.firstName);
        guest.setLastName(this.lastName);
        guest.setEmailAddress(this.emailAddress);
        guest.setAddress(this.address);
        guest.setCountry(this.country);
        guest.setState(this.state);
        guest.setPhoneNumber(this.phoneNumber);
        return guest;
    }

}

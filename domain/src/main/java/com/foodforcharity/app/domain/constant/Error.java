package com.foodforcharity.app.domain.constant;

public enum Error {

    UnknownError("Unknown Error"),
    PersonDoesNotExist("Unknown Error"),
    IncorrectUsernameOrPassword("Incorrect Username Or Password"), 
    IncorrectPassword("Incorrect Password"), 
    InvalidEmail("Email Format Is Invalid"),
    EmailAlreadyExist("Email Already Exist"),
    InvalidMemberCount("Member Count Must Be Greater Than Zero"),
    DoneeDoesNotExist("Unknown Error"),
    RequestDoesNotExist("Request Does Not Exist"),
    ComplaintDoesNotExist(" Complaint Does Not Exist"),
    DonorDoesNotExist("Unknown Error"),
    FoodDoesNotExist("Food Does Not Exist"),
    IneligibleDoneeStatus("Donee Must Be Active"), // it is either suspendid or invitial
    IneligibleDonorStatus("Donor Must Be Active Or Inactive"),
    FoodShortage("Amount Of Food Requested Is More Than Amount Of Food Available"), 
    FoodsDonorMismatch("The Foods Donot Belong To The Donor"),
    InvalidQuantityRequested("Quantity Requested Must Be Greater Than Zero"),
    QuanityAllowanceExceeded("Individual Donee  Requests Cannot  Exceed The Allocated Quantity")
    DonorRequestDontMatch("Donor Id Does Not Match Requester's Donor Id"),
    InactiveRequest("Request Has Already Been Completed")
   
    ;

    String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
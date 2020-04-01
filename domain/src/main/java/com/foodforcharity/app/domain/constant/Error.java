package com.foodforcharity.app.domain.constant;

public enum Error {

    UnknownError("Unknown Error"),
    IncorrectUsernameOrPassword("Incorrect Username Or Password"), 
    InvalidEmail("Email Format Is Invalid"),
    EmailAlreadyExist("Email Already Exist"),
    InvalidMemberCount("Member Count Must Be Greater Than Zero");

    String message;

    Error(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
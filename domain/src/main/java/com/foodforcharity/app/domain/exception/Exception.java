package com.foodforcharity.app.domain.exception;

public enum Exception {

    IncorrectUsernameOrPassword("Incorrect Username Or Password"), 
    InvalidEmail("Email Format Is Invalid"),
    EmailAlreadyExist("Email Already Exist"),
    InvalidMemberCount("Member Count Must Be Greater Than Zero");

    String message;

    Exception(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
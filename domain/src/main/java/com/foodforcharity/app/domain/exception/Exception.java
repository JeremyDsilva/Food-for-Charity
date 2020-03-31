package com.foodforcharity.app.domain.exception;

public enum Exception{

    IncorrectUsernameOrPassword("Incorrect Username Or Password"), 
    UsernameAlreadyExist("Username Already Exist");

    String message;

    Exception(String message){
        this.message = message;
    }

    String getMessage(){
        return message;
    }

}
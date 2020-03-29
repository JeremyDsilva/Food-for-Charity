package com.foodforcharity.app.usecase.account.login;

import com.foodforcharity.app.mediator.Command;

public class LoginCommand implements Command<String>{

    String username;
    String password;

    /**
     * @param username
     * @param password
     */
    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

}
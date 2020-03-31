package com.foodforcharity.app.usecase.account.login;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class LoginCommand implements Command<Response<String>>{

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
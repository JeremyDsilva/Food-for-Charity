package com.foodforcharity.app.usecase.account.createjwt;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class CreateJwtCommand implements Command<Response<String>>{

    String username;
    String password;

    /**
     * @param username
     * @param password
     */
    public CreateJwtCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

}
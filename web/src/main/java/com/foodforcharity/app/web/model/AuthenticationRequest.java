package com.foodforcharity.app.web.model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username
     * @param password
     */
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    
    
}

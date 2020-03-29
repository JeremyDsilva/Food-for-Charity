package com.foodforcharity.app.web.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;

    /**
     * @param jwt
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

}
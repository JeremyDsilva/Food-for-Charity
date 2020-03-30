package com.foodforcharity.app.domain.security;

import com.foodforcharity.app.domain.entity.Person;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    String auth;

    Authority(Person person){

    }


    @Override
    public String getAuthority() {
        return null;
    }

}
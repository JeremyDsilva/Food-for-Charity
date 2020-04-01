package com.foodforcharity.app.domain.reponse;

import java.util.ArrayList;
import java.util.List;

import com.foodforcharity.app.domain.constant.Error;

public class Response<R> {

    public R response;
    public List<Error> errors;

    public Response(){
        this.errors = new ArrayList<>();
    }

    public Response(R response){
        this.response = response;
        this.errors = new ArrayList<>();
    }

    public Response(List<Error> errors){
        this.errors = errors;
    }

    public Response(Error error){
        this();
        addError(error);
    }

    public R getResponse(){
        return response;
    }

    public  List<Error> getError(){
        return errors;
    }

    public boolean success(){
        return errors == null || errors.size() == 0;
    }

    public void addError(Error exception){
        errors.add(exception);
    }
    
}
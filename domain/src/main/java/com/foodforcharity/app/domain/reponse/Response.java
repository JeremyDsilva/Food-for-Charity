package com.foodforcharity.app.domain.reponse;

import java.util.ArrayList;
import java.util.List;

import com.foodforcharity.app.domain.exception.Exception;

public class Response<R> {

    public R response;
    public List<Exception> errors;

    public Response(){
        this.errors = new ArrayList<>();
    }

    public Response(R response){
        this.response = response;
        this.errors = new ArrayList<>();
    }

    public Response(List<Exception> errors){
        this.errors = errors;
    }

    public Response(Exception error){
        this();
        addError(error);
    }

    public R getResponse(){
        return response;
    }

    public  List<Exception> getError(){
        return errors;
    }

    public boolean success(){
        return errors == null || errors.size() == 0;
    }

    public void addError(Exception exception){
        errors.add(exception);
    }
    
}
package com.foodforcharity.app.domain.reponse;

import com.foodforcharity.app.domain.constant.Error;

public class Response<R> {

    R response;
    Error error;

    public static Response<Void> EmptyResponse() {
        return new Response<Void>();
    }

    public static <R> Response<R> of(R response){
        return new Response<R>(response);
    }

    public static <R> Response<R> of(Error error){
        return new Response<R>(error);
    }

    private Response(){
    }

    private Response(R response){
        this.response = response;
        error = null;
    }

    private Response(Error error){
        this.error = error;
    }

    public R getResponse(){
        return response;
    }

    public Error getError(){
        return error;
    }

    public boolean success(){
        return error == null;
    }

}
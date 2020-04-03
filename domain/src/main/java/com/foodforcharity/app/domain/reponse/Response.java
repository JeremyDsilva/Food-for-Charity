package com.foodforcharity.app.domain.reponse;

import com.foodforcharity.app.domain.constant.Error;

public class Response<R> {

    public R response;
    public Error error;

    public static Response<Void> EmptyResponse() {
        return new Response<Void>();
    }

    private Response(){
    }

    public Response(R response){
        this.response = response;
        error = null;
    }

    public Response(Error error){
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
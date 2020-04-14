package com.foodforcharity.app.web.model;

import java.io.Serializable;

import com.foodforcharity.app.domain.constant.Error;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Request implements Serializable {

    Boolean success;

    Error error;

    public void setSuccess(boolean success){
        this.success = success;
    }

    public static <T extends Request> T withSuccess(T request){
        request.success = true;
        return request;
    }

    public void setError(Error error){
        success = false;
        this.error = error;
    }



}
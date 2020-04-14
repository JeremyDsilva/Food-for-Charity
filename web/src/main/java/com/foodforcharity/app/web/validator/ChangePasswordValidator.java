package com.foodforcharity.app.web.validator;


import com.foodforcharity.app.web.model.ChangePasswordRequest;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ChangePasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ChangePasswordRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ChangePasswordRequest request = (ChangePasswordRequest) target;        

        if(!request.getNewPassword().equals(request.getConfirmNewPassword()))   
        {
            errors.rejectValue("confirmNewPassword", "New Password do not match");
        }

    }

}
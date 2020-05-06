package com.foodforcharity.app.usecase.account.changepassword;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Value;

@Value
public class ChangePasswordCommand implements Command<Response<Void>> {
    Long personId;
    String oldPassword;
    String newPassword;
}
package com.foodforcharity.app.usecase.useraccount.changepassword;

import com.foodforcharity.app.mediator.Command;

public class ChangePasswordCommand implements Command<Boolean> {
    String userName;
    String oldPassword;
    String newPassword;

    // Constructor
    public ChangePasswordCommand(String UserName, String OldPassword, String NewPassword) {
        this.userName = UserName;
        this.oldPassword = OldPassword;
        this.newPassword = NewPassword;
    }

}
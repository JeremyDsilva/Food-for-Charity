package com.foodforcharity.app.usecase.account.changepassword;

import com.foodforcharity.app.mediator.Command;

public class ChangePasswordCommand implements Command<Boolean> {
    Long personId;
    String oldPassword;
    String newPassword;

    /**
     * @param personId
     * @param oldPassword
     * @param newPassword
     */
    public ChangePasswordCommand(Long personId, String oldPassword, String newPassword) {
        this.personId = personId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    /**
     * 
     */
    public ChangePasswordCommand() {
    };

}
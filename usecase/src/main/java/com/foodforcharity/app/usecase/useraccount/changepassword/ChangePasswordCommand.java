package com.foodforcharity.app.usecase.useraccount.changepassword;

import com.foodforcharity.app.mediator.Command;

public class ChangePasswordCommand implements Command<Boolean> {
private String userName;
private String oldPassword;
private String newPassword;

//Constructor
public ChangePasswordCommand (String  UserName,String OldPassword,String NewPassword){
this.userName= UserName;
this.oldPassword= OldPassword;
this.newPassword=NewPassword;
} 

// setters and getters
public void setUserName(String UserName)
{
    this.userName=UserName;
}
public String getUserName(){
    return userName;
}
public void setOldPassword(String OldPassword){
    this.oldPassword= OldPassword;
}
public String getOldPassword(){
    return oldPassword;
}
public void setNewPassword(String NewPassword){
    this.newPassword= NewPassword;
}
public String getNewPassword(){
    return newPassword;
}


}
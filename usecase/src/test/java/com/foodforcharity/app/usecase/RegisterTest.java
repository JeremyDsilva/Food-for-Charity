package com.foodforcharity.app.usecase;

import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.register.RegisterCommand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTest {

    @Autowired
    CommandHandler<RegisterCommand, Response<Void>> handler;

    public RegisterTest() {
    }

    @Test
    public void testHandler() {
        RegisterCommand command = new RegisterCommand("DonorName", "DonorPassword", "donorEmail@gmail.com", PersonRole.Donor,
                "12334566", "DonorCity", "DonorCountry", "DonorAddress");
        Response<Void> response = handler.handle(command);        
    }

}
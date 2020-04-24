package com.foodforcharity.app.usecase.account;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.infrastructure.repository.PersonRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.account.donorregisteration.DonorRegisterationCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DonorRegisterationTest {

    @Autowired
    CommandHandler<DonorRegisterationCommand, Response<Void>> handler;

    @Autowired
    PersonRepository repos;

    @Test
    public void successTest() {
        repos.findByUsername("donorEmail@gmail.com").ifPresent(person -> repos.delete(person));

        DonorRegisterationCommand command = new DonorRegisterationCommand("DonorName", "DonorPassword",
                "donorEmail@gmail.com", "12334566", "DonorCity", "DonorCountry", "DonorAddress");
        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void InvalidemailErrorTest() {
        DonorRegisterationCommand command = new DonorRegisterationCommand("DonorName", "DonorPassword", "donorEmail",
                "12334566", "DonorCity", "DonorCountry", "DonorAddress");
        assert (handler.handle(command).getError() == Error.InvalidEmail);
    }


    @Test
    public void EmailAlreadyExistTest() {
        successTest();
        DonorRegisterationCommand command = new DonorRegisterationCommand("DonorName", "DonorPassword", "donorEmail@gmail.com",
                "12334566", "DonorCity", "DonorCountry", "DonorAddress");
        assert (handler.handle(command).getError() == Error.EmailAlreadyExist);
    }
}
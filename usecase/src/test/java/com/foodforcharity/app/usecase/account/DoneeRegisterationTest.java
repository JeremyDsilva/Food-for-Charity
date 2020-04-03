package com.foodforcharity.app.usecase.account;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;
import com.foodforcharity.app.usecase.account.doneeregisteration.DoneeRegisterationCommand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoneeRegisterationTest {

    @Autowired
    CommandHandler<DoneeRegisterationCommand, Response<Void>> handler;

    @Autowired
    PersonRepository repos;

    @Test
    public void successTest() {
        repos.findByUsername("doneeEmail@gmail.com").ifPresent(person -> repos.delete(person));

        DoneeRegisterationCommand command = new DoneeRegisterationCommand("DoneeName", "DoneePassword",
                "doneeEmail@gmail.com", "12334566", "DoneeCity", "DoneeCountry", "DoneeAddress", DoneeType.Individual,
                1);
        Response<Void> response = handler.handle(command);
        assert (response.success());
    }

    @Test
    public void emailErrorTest() {
        DoneeRegisterationCommand command = new DoneeRegisterationCommand("DoneeName", "DoneePassword", "doneeEmail",
                "12334566", "DoneeCity", "DoneeCountry", "DoneeAddress", DoneeType.Individual, 1);
        assert (handler.handle(command).getError() == Error.InvalidEmail);
    }

    @Test
    public void invalidMemberCountErrorTest() {
        DoneeRegisterationCommand command = new DoneeRegisterationCommand("DoneeName", "DoneePassword", "doneeEmail@gmail.com",
                "12334566", "DoneeCity", "DoneeCountry", "DoneeAddress", DoneeType.Individual, -1);
        assert (handler.handle(command).getError() == Error.InvalidMemberCount);
    }

}
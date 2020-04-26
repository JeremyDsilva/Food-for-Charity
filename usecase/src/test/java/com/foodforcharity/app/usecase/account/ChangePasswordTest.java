package com.foodforcharity.app.usecase.account;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChangePasswordTest {

    @Autowired
    CommandHandler<ChangePasswordCommand, Response<Void>> handler;

    @Autowired
    DonorRepository repos;

    Donor donor = null;

    @Before
    public void init() {

        donor = new Donor();
        donor.setAddressDescription("DonorAddressDescription");
        donor.setCity("DonorCity");
        donor.setCountry("DonorCountry");
        donor.setDonorName("DonorName");
        donor.setDonorStatus(DonorStatus.Initial);
        donor.setEmail("donoremail@gmail.com");
        donor.setNumberOfRating(0);
        donor.setPassword("DonorPassword");
        donor.setPhoneNumber("DonorPhoneNumber");
        donor.setRating(0);
        donor.setUsername(donor.getEmail());
        donor.setDiscountApplied(0);

        donor = repos.save(donor);

    }

    @After
    public void Destroy(){
    
        
        repos.deleteById(donor.getId());
    
    }

    @Test
    public void successTest() {
        ChangePasswordCommand command = new ChangePasswordCommand(donor.getId(), donor.getPassword(), "NewPassword");
        assert (handler.handle(command).success());
    }

    @Test
    public void incorrectPasswordTest() {
        ChangePasswordCommand command = new ChangePasswordCommand(donor.getId(), "InvalidPassword", "NewPassword");
        assert (handler.handle(command).getError() == Error.IncorrectPassword);
    }

    @Test
    public void personNotFoundTest() {
        ChangePasswordCommand command = new ChangePasswordCommand(Long.valueOf(100), donor.getPassword(),
                "NewPassword");

        assert (handler.handle(command).getError() == Error.PersonDoesNotExist);
    }

}
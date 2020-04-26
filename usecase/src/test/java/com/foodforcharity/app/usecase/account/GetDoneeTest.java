package com.foodforcharity.app.usecase.account;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.account.getdonee.GetDoneeCommand;
import org.aspectj.bridge.ICommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetDoneeTest {

    @Autowired
    CommandHandler<GetDoneeCommand, Response<Donee>> handler;

    @Autowired
    DoneeRepository repos;

    Donee donee;

    @Before
    public void init(){
        donee = new Donee();
        donee.setAddressDescription("DoneeAddressDescription");
        donee.setCity("DoneeCity");
        donee.setCountry("DoneeCountry");
        donee.setDoneeName("DoneeName");
        donee.setDoneeStatus(DoneeStatus.Active);
        donee.setEmail("doneeemail@gmail.com");
        donee.setDoneeType(DoneeType.Individual);
        donee.setPassword("DoneePassword");
        donee.setPhoneNumber("DoneePhoneNumber");
        donee.setMemberCount(2);
        donee.setQuantityRequested(0);
        donee.setUsername(donee.getEmail());
        donee = repos.save(donee);
    }

    @After
    public void destroy(){
        donee = ((DoneeService) repos).findById(donee.getId()).get();
        repos.deleteById(donee.getId());
    }

    @Test
    public void success(){
        GetDoneeCommand command = new GetDoneeCommand(donee.getId());
        Response<Donee> response = handler.handle(command);

        assert(response.success() && response.getResponse() != null);
    }
    
}

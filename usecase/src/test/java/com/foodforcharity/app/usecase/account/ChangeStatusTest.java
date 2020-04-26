package com.foodforcharity.app.usecase.account;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.infrastructure.repository.DoneeRepository;
import com.foodforcharity.app.infrastructure.repository.DonorRepository;
import com.foodforcharity.app.infrastructure.repository.PersonRepository;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.account.changestatus.ChangeStatusCommand;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChangeStatusTest {

    @Autowired
    CommandHandler<ChangeStatusCommand, Response<Void>> handler;

    @Autowired
    PersonRepository personRepos;

    @Autowired
    DonorRepository donorRepos;

    @Autowired
    DoneeRepository doneeRepos;

    Donor donor;
    Donee donee;

    @Before
    public void init() {

        donor = new Donor();
        donor.setAddressDescription("DonorAddressDescription");
        donor.setCity("DonorCity");
        donor.setCountry("DonorCountry");
        donor.setDonorName("DonorName");
        donor.setDonorStatus(DonorStatus.Active);
        donor.setEmail("donoremail@gmail.com");
        donor.setNumberOfRating(0);
        donor.setPassword("DonorPassword");
        donor.setPhoneNumber("DonorPhoneNumber");
        donor.setRating(0);
        donor.setUsername(donor.getEmail());
        donor.setDiscountApplied(0);

        donorRepos.save(donor);

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
        donee = doneeRepos.save(donee);

    }


    @After
public void Destroy(){

    doneeRepos.deleteById(donee.getId());
    donorRepos.deleteById(donor.getId());

}
    @Test
    public void successTest() {
        ChangeStatusCommand donorCommand = new ChangeStatusCommand(donor.getId(), DonorStatus.Active);
        ChangeStatusCommand doneeCommand = new ChangeStatusCommand(donee.getId(), DoneeStatus.Active);
        assert (handler.handle(donorCommand).success());
        assert (handler.handle(doneeCommand).success());
    }

    @Test
    public void emptyDoneeStatusFieldTest() {
        ChangeStatusCommand donorCommand = new ChangeStatusCommand(donee.getId(), DonorStatus.Active);
        assert (handler.handle(donorCommand).getError() == Error.EmptyDoneeStatusField);
    }

    @Test
    public void emptyDonorStatusFieldTest() {
        ChangeStatusCommand donorCommand = new ChangeStatusCommand(donor.getId(), DoneeStatus.Active);
        assert (handler.handle(donorCommand).getError() == Error.EmptyDonorStatusField);
    }

    @Test
    public void personDoesNotExistTest() {
        ChangeStatusCommand donorCommand = new ChangeStatusCommand(Long.valueOf(100), DonorStatus.Active);
        assert (handler.handle(donorCommand).getError() == Error.PersonDoesNotExist);
    }

}
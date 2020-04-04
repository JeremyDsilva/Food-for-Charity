package com.foodforcharity.app.usecase.account;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.PersonRepository;
import com.foodforcharity.app.usecase.account.changestatus.ChangeStatusCommand;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;

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
        Optional<Donor> dbDonor = donorRepos.findById(Long.valueOf(1));

        if (dbDonor.isPresent()) {
            donor = dbDonor.get();
        } else {

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

            donorRepos.save(donor);
        }

        Optional<Donee> dbDonee = doneeRepos.findById(Long.valueOf(6));

        if (dbDonee.isPresent()) {
            donee = dbDonee.get();

        } else {

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
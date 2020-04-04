package com.foodforcharity.app.usecase.account;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.DonorStatus;
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
           donee=doneeRepos.save(donee);
        }


        
    }

    @Test
    public void successTest(){

        ChangeStatusCommand command1 = new ChangeStatusCommand(donor.getId());
        command1.setDonorStatus(DonorStatus.Active);

      ChangeStatusCommand command2= new ChangeStatusCommand(donee.getId());
      command2.setDoneeStatus(DoneeStatus.Active);

    Response<Void> response1 = handler.handle(command1);
    Response<Void> response2 = handler.handle(command2);
    
    assert (response1.success() && response2.success());
    }

}
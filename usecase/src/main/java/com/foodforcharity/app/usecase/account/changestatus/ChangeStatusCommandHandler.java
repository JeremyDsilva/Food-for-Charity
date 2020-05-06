package com.foodforcharity.app.usecase.account.changestatus;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangeStatusCommandHandler implements CommandHandler<ChangeStatusCommand, Response<Void>> {
    PersonService personService;
    DonorService donorService;
    DoneeService doneeService;

    /**
     * Public Constructor
     *
     * @param personService
     * @param donorService
     * @param doneeService
     */
    @Autowired
    public ChangeStatusCommandHandler(PersonService personService, DonorService donorService,
                                      DoneeService doneeService) {
        this.personService = personService;
        this.donorService = donorService;
        this.doneeService = doneeService;
    }

    /**
     * @param ChangeStatusCommand
     * @return Response<Void>
     */
    @Override
    public Response<Void> handle(ChangeStatusCommand command) {
        try {
            // check if person exists
            Optional<Person> dbPerson = personService.findById(command.getPersonId());
            if (dbPerson.isEmpty()) {
                return Response.of(Error.PersonDoesNotExist);
            }
            Person person = dbPerson.get();
            // if person is donee /check that donee status is not empty
            if (person instanceof Donee && command.doneeStatus.isEmpty()) {
                return Response.of(Error.EmptyDoneeStatusField);
            }
            // if person is donor /check that donor status is not empty
            if (person instanceof Donor && command.donorStatus.isEmpty()) {
                return Response.of(Error.EmptyDonorStatusField);
            }
            // ----------after all conditions are met---------------

            // update the status of the person
            if (person instanceof Donor) {
                Donor donor = (Donor) person;
                donor.setDonorStatus(command.getDonorStatus().get());
                donorService.save(donor);
            } else if (person instanceof Donee) {
                Donee donee = (Donee) person;
                donee.setDoneeStatus(command.getDoneeStatus().get());
                doneeService.save(donee);
            }
        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }
        // send reponse
        return Response.EmptyResponse();

    }

}
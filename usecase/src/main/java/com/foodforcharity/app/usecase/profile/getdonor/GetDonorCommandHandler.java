package com.foodforcharity.app.usecase.profile.getdonor;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetDonorCommandHandler implements CommandHandler<GetDonorCommand, Response<Donor>> {

    private final PersonService service;

    @Autowired
    public GetDonorCommandHandler(PersonService service) {
        this.service = service;
    }

    @Override
    public Response<Donor> handle(GetDonorCommand command) {

        Optional<Person> dbPerson = service.findById(command.getPersonId());

        if (dbPerson.isEmpty() || !(dbPerson.get() instanceof Donor))
            return Response.of(Error.DonorDoesNotExist);

        return Response.of((Donor) dbPerson.get());
    }

}
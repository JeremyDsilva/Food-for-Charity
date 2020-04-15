package com.foodforcharity.app.usecase.account.changepassword;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordCommandHandler implements CommandHandler<ChangePasswordCommand, Response<Void>> {

    private final PersonService personService;

    @Autowired
    ChangePasswordCommandHandler(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Response<Void> handle(ChangePasswordCommand command) {

        try {

            Optional<Person> dbPerson = personService.findById(command.getPersonId());

            if (dbPerson.isPresent()) {
                Person person = dbPerson.get();
                if (person.getPassword().equals(command.getOldPassword())) {
                    person.setPassword(command.getNewPassword());
                    personService.save(person);
                    return Response.EmptyResponse();
                } else {
                    return Response.of(Error.IncorrectPassword);
                }
            } else {
                return Response.of(Error.PersonDoesNotExist);
            }

        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }

    }

}
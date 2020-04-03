package com.foodforcharity.app.usecase.account.changepassword;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordCommandHandler implements CommandHandler<ChangePasswordCommand, Response<Void>> {

    private final PersonRepository personRepository;

    @Autowired
    ChangePasswordCommandHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Response<Void> handle(ChangePasswordCommand command) {

        try {

            Optional<Person> dbPerson = personRepository.findById(command.personId);

            if (dbPerson.isPresent()) {
                Person person = dbPerson.get();
                if (person.getPassword().equals(command.oldPassword)) {
                    person.setPassword(command.newPassword);
                    personRepository.save(person);
                    return Response.EmptyResponse();
                } else {
                    return new Response<Void>(Error.IncorrectPassword);
                }
            } else {
                return new Response<Void>(Error.PersonDoesNotExist);
            }

        } catch (Exception e) {
            return new Response<Void>(Error.UnknownError);
        }

    }

}
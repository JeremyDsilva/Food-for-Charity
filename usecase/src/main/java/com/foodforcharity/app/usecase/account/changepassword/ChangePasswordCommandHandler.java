package com.foodforcharity.app.usecase.account.changepassword;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordCommandHandler implements CommandHandler<ChangePasswordCommand, Boolean> {

    private final PersonRepository personRepository;

    @Autowired
    ChangePasswordCommandHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Boolean handle(ChangePasswordCommand command) {

        try {

            Optional<Person> dbPerson = personRepository.findById(command.personId);

            if (dbPerson.isPresent()) {
                Person person = dbPerson.get();
                if (person.getPassword() == command.oldPassword) {
                    person.setPassword(command.newPassword);
                    personRepository.save(person);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
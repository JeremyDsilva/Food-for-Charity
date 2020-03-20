package com.foodforcharity.app.usecase.useraccount.changepassword;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordCommandHandler implements CommandHandler<ChangePasswordCommand, Boolean> {

    private final PersonRepository personRepository;

    @Autowired
    ChangePasswordCommandHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private String getPasswordHash(String Password) {
        // hashing algo
        return Password;
    }

    private String getPasswordSalt(String Password) {
        // hashing algo
        return Password;
    }

    @Override
    public Boolean handle(ChangePasswordCommand command) {
        try {

            Optional<Person> dbPerson = personRepository.findByUsername(command.getUserName());

            if (dbPerson.isPresent()) {
                Person person = dbPerson.get();
                if (person.getPasswordHash() == getPasswordHash(command.getOldPassword())) {
                    // setnew password
                    person.setPasswordHash(getPasswordHash(command.getNewPassword()));
                    person.setPasswordSalt(getPasswordSalt(command.getNewPassword()));

                    // save back to repository
                    personRepository.save(person);

                    return true;
                } else {
                    return false;
                }
            }

            else {
                // return false
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
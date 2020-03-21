package com.foodforcharity.app.usecase.useraccount.changepassword;

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

            Optional<Person> dbPerson = personRepository.findByUsername(command.userName);

            if (dbPerson.isPresent()) {
                Person person = dbPerson.get();
                if (person.getPasswordHash() == getPasswordHash(command.oldPassword)) {
                    // setnew password
                    person.setPasswordHash(getPasswordHash(command.newPassword));
                    person.setPasswordSalt(getPasswordSalt(command.newPassword));

                    personRepository.save(person); // save back to repository

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
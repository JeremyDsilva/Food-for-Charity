package com.foodforcharity.app.usecase.useraccount.changepassword;

import java.util.Optional;
import java.util.concurrent.Future;

import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;

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
    public Future<Boolean> handle(ChangePasswordCommand command) {

        Future< Optional<Person>> futureOptionalPerson= personRepository.findByUsername(command.getUserName());
       try{
        Optional<Person> optionalPerson = futureOptionalPerson.get(); // blocks untill we get the optional person 
      
     
        if (optionalPerson.isPresent()){
          Person person= optionalPerson.get();
          if (person.getPasswordHash()==getPasswordHash(command.getOldPassword())){
              //setnew password 
              person.setPasswordHash(getPasswordHash(command.getNewPassword()));
              person.setPasswordSalt(getPasswordSalt(command.getNewPassword()));

              //save back to repository
              personRepository.save(person);

              //return true
              return new AsyncResult<Boolean> (true);

          }
          else{
             //return false 
             return new AsyncResult<Boolean> (false);
          }
      }

      else{
          
          //return false
          return new AsyncResult<Boolean> (false);
      }
      
    }
    catch (Exception e){
        System.out.println(e.getMessage());
        return new AsyncResult<Boolean> (false);
    }

    }

}
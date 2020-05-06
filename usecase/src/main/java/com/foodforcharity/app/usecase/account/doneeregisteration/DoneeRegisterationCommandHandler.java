package com.foodforcharity.app.usecase.account.doneeregisteration;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommandHandler class for RegisterCommand
 **/
@Service
public class DoneeRegisterationCommandHandler implements CommandHandler<DoneeRegisterationCommand, Response<Void>> {
    private final PersonService personService;
    private final DoneeService doneeService;

    /**
     * Public Constructor
     *
     * @param personService
     * @param doneeService
     */
    @Autowired
    public DoneeRegisterationCommandHandler(PersonService personService, DoneeService doneeService) {
        this.personService = personService;
        this.doneeService = doneeService;
    }

    @Override
    public Response<Void> handle(DoneeRegisterationCommand command) {

        if (!isValid(command.getEmail())) {
            return Response.of(Error.InvalidEmail);
        }

        if (personService.findByUsername(command.getEmail()).isPresent()) {
            return Response.of(Error.EmailAlreadyExist);
        }

        try {
            int minimumMemberCount = 1;
            if (command.getMemberCount() < minimumMemberCount) {
                return Response.of(Error.InvalidMemberCount);
            }

            Donee donee = new Donee();
            donee.setUsername(command.getEmail());
            donee.setPassword(command.getPassword()); // for now

            donee.setDoneeName(command.getName());
            donee.setAddressDescription(command.getAddress());
            donee.setCity(command.getCity());
            donee.setEmail(command.getEmail());
            donee.setCountry(command.getCountry());
            donee.setPhoneNumber(command.getPhoneNumber());

            donee.setDoneeStatus(DoneeStatus.Initial);
            donee.setQuantityRequested(0); // is this required over here??
            donee.setDoneeType(command.getDoneeType());
            donee.setMemberCount(command.getMemberCount());

            doneeService.save(donee);

        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }

        return Response.EmptyResponse();
    }

    public boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}

/**
 * Optional<Person> dbPerson = personService.findById(command.personId);
 * step1: valid and check if email is unique step 2 : check personrole ->donee
 * /donor->there is no register as broker option so no exception if donee: check
 * if member count is valid create a donee with all fileds+ donee status=initial
 * and qty requested =0
 * <p>
 * save donee to repositry else if donor: create a donor with all fileds+ donor
 * status=initial save donor to rep save person to rep
 */
package com.foodforcharity.app.usecase.account.doneeregisteration;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommandHandler class for RegisterCommand
 *
 **/
@Service
public class DoneeRegisterationCommandHandler implements CommandHandler<DoneeRegisterationCommand, Response<Void>> {
	private final PersonRepository personRepository;
	private final DoneeRepository doneeRepository;

	/**
	 * Public Constructor
	 * 
	 * @param personRepository
	 * @param doneeRepository
	 * @param donorRepository
	 */
	@Autowired
	public DoneeRegisterationCommandHandler(PersonRepository personRepository, DoneeRepository doneeRepository) {
		this.personRepository = personRepository;
		this.doneeRepository = doneeRepository;
	}

	@Override
	public Response<Void> handle(DoneeRegisterationCommand command) {

		if (!isValid(command.email)) {
			return Response.of(Error.InvalidEmail);
		}

		if (personRepository.findByUsername(command.email).isPresent()) {
			return Response.of(Error.EmailAlreadyExist);
		}

		try {
				int minimumMemberCount = 1;
				if (command.memberCount < minimumMemberCount) {
					return Response.of(Error.InvalidMemberCount);
				}

				Donee donee = new Donee();
				donee.setUsername(command.email);
				donee.setPassword(command.password); // for now

				donee.setDoneeName(command.name);
				donee.setAddressDescription(command.address);
				donee.setCity(command.city);
				donee.setEmail(command.email);
				donee.setCountry(command.country);
				donee.setPhoneNumber(command.phoneNumber);

				donee.setDoneeStatus(DoneeStatus.Initial);
				donee.setQuantityRequested(0); // is this required over here??
				donee.setDoneeType(command.doneeType);
				donee.setMemberCount(command.memberCount);

				doneeRepository.save(donee);

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
 * Optional<Person> dbPerson = personRepository.findById(command.personId);
 * step1: valid and check if email is unique step 2 : check personrole ->donee
 * /donor->there is no register as broker option so no exception if donee: check
 * if member count is valid create a donee with all fileds+ donee status=initial
 * and qty requested =0
 *
 * save donee to repositry else if donor: create a donor with all fileds+ donor
 * status=initial save donor to rep save person to rep
 */
package com.foodforcharity.app.usecase.account.donorregisteration;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommandHandler class for RegisterCommand
 *
 **/
@Service
public class DonorRegisterationCommandHandler implements CommandHandler<DonorRegisterationCommand, Response<Void>> {
	private final PersonRepository personRepository;
	private final DonorRepository donorRepository;

	/**
	 * Public Constructor
	 * 
	 * @param personRepository
	 * @param doneeRepository
	 * @param donorRepository
	 */
	@Autowired
	public DonorRegisterationCommandHandler(PersonRepository personRepository,
			DonorRepository donorRepository) {
		this.personRepository = personRepository;
		this.donorRepository = donorRepository;
	}

	@Override
	public Response<Void> handle(DonorRegisterationCommand command) {

		if (!isValid(command.email)) {
			return new Response<Void>(Error.InvalidEmail);
		}

		if (personRepository.findByUsername(command.email).isPresent()) {
			return new Response<Void>(Error.EmailAlreadyExist);
		}

		try {
			Donor donor = new Donor();
			donor.setUsername(command.email);
			donor.setPassword(command.password); // for now

			donor.setDonorName(command.name);
			donor.setAddressDescription(command.address);
			donor.setCity(command.city);
			donor.setEmail(command.email);
			donor.setCountry(command.country);
			donor.setPhoneNumber(command.phoneNumber);
			donor.setRating(0);
			donor.setNumberOfRating(0);

			donor.setDonorStatus(DonorStatus.Initial);

			donorRepository.save(donor);
		} catch (Exception e) {
			return new Response<Void>(Error.UnknownError);
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
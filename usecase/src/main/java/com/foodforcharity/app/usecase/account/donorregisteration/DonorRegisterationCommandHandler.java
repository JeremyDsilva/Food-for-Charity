package com.foodforcharity.app.usecase.account.donorregisteration;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DonorService;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommandHandler class for RegisterCommand
 *
 **/
@Service
public class DonorRegisterationCommandHandler implements CommandHandler<DonorRegisterationCommand, Response<Void>> {
	private final PersonService personService;
	private final DonorService donorService;

	/**
	 * Public Constructor
	 * 
	 * @param personService
	 * @param doneeService
	 * @param donorService
	 */
	@Autowired
	public DonorRegisterationCommandHandler(PersonService personService,
			DonorService donorService) {
		this.personService = personService;
		this.donorService = donorService;
	}

	@Override
	public Response<Void> handle(DonorRegisterationCommand command) {

		if (!isValid(command.email)) {
			return Response.of(Error.InvalidEmail);
		}

		if (personService.findByUsername(command.email).isPresent()) {
			return Response.of(Error.EmailAlreadyExist);
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
			donor.setDiscountApplied(0);

			donor.setDonorStatus(DonorStatus.Initial);

			donorService.save(donor);
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
 *
 * save donee to repositry else if donor: create a donor with all fileds+ donor
 * status=initial save donor to rep save person to rep
 */
package com.foodforcharity.app.usecase.account.register;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommandHandler class for RegisterCommand 
 *
 **/
@Service
public class RegisterCommandHandler implements CommandHandler<RegisterCommand, Response<Void>> {
	private final PersonRepository personRepository;
	private final DoneeRepository doneeRepository;
	private final DonorRepository donorRepository;

	/**
	 * Public Constructor
	 * 
	 * @param personRepository
	 * @param doneeRepository
	 * @param donorRepository
	 */
	@Autowired
	public RegisterCommandHandler(PersonRepository personRepository, DoneeRepository doneeRepository,
			DonorRepository donorRepository) {
		this.personRepository = personRepository;
		this.doneeRepository = doneeRepository;
		this.donorRepository = donorRepository;
	}

	@Override
	public Response<Void> handle(RegisterCommand command) {

		if (!isValid(command.email)) {
			return new Response<Void>(Error.InvalidEmail);
		}

		Optional<Person> dbPerson = personRepository.findByUsername(command.email);
		if (dbPerson.isPresent()) {
			return new Response<Void>(Error.EmailAlreadyExist);
		}

		try {
			if (command.personRole == PersonRole.Donee) {
				// check number of memebers

				int minimumMemberCount = 1;

				if (command.memberCount.get() < minimumMemberCount) {
					return new Response<Void>(Error.InvalidMemberCount);
				}

				Donee donee = new Donee();
				donee.setUsername(command.email);
				donee.setPasswordHash(command.password); // for now
				donee.setPasswordSalt(command.password); // for now

				donee.setDoneeName(command.name);
				donee.setAddressDescription(command.address);
				donee.setCity(command.city);
				donee.setEmail(command.email);
				donee.setCountry(command.country);
				donee.setPhoneNumber(command.phoneNumber);

				donee.setDoneeStatus(DoneeStatus.Initial);
				donee.setQuantityRequested(0); // is this required over here??
				donee.setDoneeType(command.doneeType.get());
				donee.setMemberCount(command.memberCount.get());

				doneeRepository.save(donee);

			} else if (command.personRole == PersonRole.Donor) {
				// for donor
				Donor donor = new Donor();
				donor.setUsername(command.email);
				donor.setPasswordHash(command.password); // for now
				donor.setPasswordSalt(command.password); // for now

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
			} else {
				return new Response<Void>(Error.UnknownError);
			}
		} catch (Exception e) {
			return new Response<Void>(Error.UnknownError);
		}

		return new Response<Void>();

	}

	static boolean isValid(String email) {
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
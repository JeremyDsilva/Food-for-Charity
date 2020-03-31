package com.foodforcharity.app.usecase.account.register;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;

import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.exception.Exception;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.service.PersonRepository;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern; // --> again i am getting this even though i use it ??? why??

@Service
public class RegisterCommandHandler implements CommandHandler<RegisterCommand, Response<Void>> {
	private final PersonRepository personRepository;
	private final DoneeRepository doneeRepository;
	private final DonorRepository donorRepository;
	// public RegisterCommandHandler(){

	// }

	/**
	 * Public Constructor
	 * 
	 * @param personRepository
	 * @param doneeRepository
	 * @param donorRepository
	 */
	public RegisterCommandHandler(PersonRepository personRepository, DoneeRepository doneeRepository,
			DonorRepository donorRepository) {
		this.personRepository = personRepository;
		this.doneeRepository = doneeRepository;
		this.donorRepository = donorRepository;
	}

	@Override
	public Response<Void> handle(RegisterCommand command) {

		if (isValid(command.email)) {
			Optional<Person> dbPerson = personRepository.findByUsername(command.email);

			if (dbPerson.isPresent()) {
				return new Response<Void>(Exception.EmailAlreadyExist);
			} else {

				if (command.personRole == PersonRole.Donee) {
					// check number of memebers
					if (command.memberCount.get() < 0) {
						return new Response<Void>(Exception.InvalidMemberCount);
					} else {
						Donee donee = new Donee();
						donee.setUsername(command.email);
						donee.setPersonRole(command.personRole);
						donee.setPasswordHash(command.password); // for now
						donee.setPasswordSalt(command.password); // for now
						donee.setAddressDescription(command.address);
						donee.setCity(command.city);
						donee.setEmail(command.email);
						donee.setCountry(command.country);
						donee.setPhoneNumber(command.phoneNumber);
						donee.setDoneeStatus(DoneeStatus.Initial);
						donee.setQuantityRequested(0); // is this required over here??
						donee.setDoneeType(command.doneeType.get());
						doneeRepository.save(donee);
						donee.setMemberCount(command.memberCount.get());
						return new Response<Void>();
					}

				} else {
					// for donor
					Donor donor = new Donor();
					donor.setUsername(command.email);
					donor.setPersonRole(command.personRole);
					donor.setPasswordHash(command.password); // for now
					donor.setPasswordSalt(command.password); // for now
					donor.setAddressDescription(command.address);
					donor.setCity(command.city);
					donor.setEmail(command.email);
					donor.setCountry(command.country);
					donor.setPhoneNumber(command.phoneNumber);
					donor.setDonorStatus(DonorStatus.Initial);
					donor.setDonorStatus(DonorStatus.Initial);
					donorRepository.save(donor);

					return new Response<Void>();
				}
			}

		} else {
			return new Response<Void>(Exception.InvalidEmail);
		}

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
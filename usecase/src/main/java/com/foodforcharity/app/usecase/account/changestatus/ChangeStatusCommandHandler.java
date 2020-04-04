package com.foodforcharity.app.usecase.account.changestatus;

import java.util.Optional;

import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.DoneeRepository;
import com.foodforcharity.app.service.DonorRepository;
import com.foodforcharity.app.service.PersonRepository;
import com.foodforcharity.app.domain.constant.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeStatusCommandHandler implements CommandHandler<ChangeStatusCommand, Response<Void>> {
	private static final Donor DonorRepository = null;
	PersonRepository personRepository;
	DonorRepository donorRepository;
	DoneeRepository doneeRepository;

	/**
	 * Public Constructor
	 * 
	 * @param personRepository
	 * @param donorRepository
	 * @param doneeRepository
	 */
	@Autowired
	public ChangeStatusCommandHandler(PersonRepository personRepository,
			com.foodforcharity.app.service.DonorRepository donorRepository, DoneeRepository doneeRepository) {
		this.personRepository = personRepository;
		this.donorRepository = donorRepository;
		this.doneeRepository = doneeRepository;
	}

	/**
	 * @param ChangeStatusCommand
	 * @return Response<Void>
	 */
	@Override
	public Response<Void> handle(ChangeStatusCommand command) {
		try {
			// check if person exists
			Optional<Person> dbPerson = personRepository.findById(command.personId);
			if (dbPerson.isEmpty()) {
				return Response.of(Error.PersonDoesNotExist);
			}
			Person person = dbPerson.get();
			// if person is donee /check that donee status is not empty
			if (person instanceof Donee && command.doneeStatus.isEmpty()) {
				return Response.of(Error.EmptyDoneeStatusField);
			}
			// if person is donor /check that donor status is not empty
			if (person instanceof Donor && command.donorStatus.isEmpty()) {
				return Response.of(Error.EmptyDonorStatusField);
			}
			// ----------after all conditions are met---------------

			// update the status of the person
			if (person instanceof Donor) {
				Donor donor = donorRepository.findById(command.personId).get();
				donor.setDonorStatus(command.donorStatus.get());
				;
				donorRepository.save(donor);
			} else if (person instanceof Donee) {
				Donee donee = doneeRepository.findById(command.personId).get();
				donee.setDoneeStatus(command.doneeStatus.get());
				;
				doneeRepository.save(donee);
			}
		} catch (Exception e) {
			return Response.of(Error.UnknownError);
		}
		// send reponse
		return Response.EmptyResponse();

	}

}
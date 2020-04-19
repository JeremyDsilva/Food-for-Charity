package com.foodforcharity.app.usecase.profile.getdonee;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.PersonService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDoneeCommandHandler implements CommandHandler<GetDoneeCommand, Response<Donee>> {

	private final PersonService service;

	@Autowired
	public GetDoneeCommandHandler(PersonService service){
		this.service = service;
	}

	@Override
	public Response<Donee> handle(GetDoneeCommand command) {
		
		Optional<Person> dbPerson = service.findById(command.getPersonId());

		if(dbPerson.isEmpty() || !(dbPerson.get() instanceof Donee))
			return Response.of(Error.DoneeDoesNotExist);

		return Response.of((Donee) dbPerson.get());			
	}

}
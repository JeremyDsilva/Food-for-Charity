package com.foodforcharity.app.usecase.reviews.viewcomplaint;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Complaint;
import com.foodforcharity.app.domain.entity.Donor;
import com.foodforcharity.app.domain.entity.Person;
import com.foodforcharity.app.domain.entity.Request;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.ComplaintRepository;
import com.foodforcharity.app.service.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewComplaintCommandHandler implements CommandHandler<ViewComplaintCommand, Response<Complaint>> {
	ComplaintRepository complaintRepository;
	PersonRepository personRepository;

	/**
	 * Public Constructor
	 * 
	 * @param complaintRepository
	 * @param personRepository
	 */
	@Autowired
	public ViewComplaintCommandHandler(ComplaintRepository complaintRepository, PersonRepository personRepository) {
		this.complaintRepository = complaintRepository;
		this.personRepository = personRepository;
	}

	@Override
	public Response<Complaint> handle(ViewComplaintCommand command) {
		Response<Complaint> response;
		// 1-check if complaint exists
		response = checkComplaintExists(command.complaintId);
		if (!response.errors.isEmpty()) {
			return response;
		}
		Complaint complaint = complaintRepository.findById(command.complaintId).get();
		// 2- check if personId Exists

		Person person = personRepository.findById(command.personId).get();
		response = checkPersonExists(command.personId);
		if (!response.errors.isEmpty()) {
			return response;
		}
		// 3- if person is donor check if donor is eligible and authentic
		if (person instanceof Donor) {
			Request request=complaint.getRequest();
			response = checkDonorAuthenticEligible(request);
			if (!response.errors.isEmpty()) {
				return response;
			}

		}
		// 3- if person is donee check if donee is eligible and authentic

		// 4- return complaint
		return new Response<Complaint>(complaint);

	}

	//because only those who filed complaints and are not suspended/initial can view complaints
	private Response<Complaint> checkDonorAuthenticEligible(Request request) {

		Donor donor= request.getDonor();
		// if(Donor.)//

		// assuming only intital donors can view a complaint
		if (donor.getDonorStatus()==DonorStatus.Initial) {
			return new Response<Complaint>(Error.IneligibleDonorStatus);
		}
		return new Response<Complaint>();
	}

	private Response<Complaint> checkPersonExists(long personId) {
		Optional<Person> dbPerson = personRepository.findById(personId);
		if (dbPerson.isEmpty()) {
			return new Response<Complaint>(Error.PersonDoesNotExist);
		}
		
		return new Response<Complaint>();
	}

	private Response<Complaint> checkComplaintExists(long complaintId) {
		Optional<Complaint> dbComplaint = complaintRepository.findById(complaintId);
		if (dbComplaint.isEmpty()) {
			return new Response<Complaint>(Error.ComplaintDoesNotExist);
		}
		
		return new Response<Complaint>();
	}

}

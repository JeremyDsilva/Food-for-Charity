package com.foodforcharity.app.usecase.account.register;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.mediator.Command;

public class RegisterCommand implements Command<Void> {
	String name;
	String password;
	String email;
	String phoneNumber;
	String city;
	String address;
	
	PersonRole personRole;
	Optional<DoneeType> doneeType;
	Optional<Integer> memberCount;

	public RegisterCommand() {

	}

	/**
	 * Public constructor
	 * 
	 * @param name
	 * @param password
	 * @param email
	 * @param personRole
	 * @param phoneNumber
	 * @param city
	 * @param address
	 */
	public RegisterCommand(String name, String password, String email, PersonRole personRole, String phoneNumber,
			String city, String address) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.personRole = personRole;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
		this.doneeType = Optional.empty();
		this.memberCount = Optional.empty();
	}

	/**
	 * 
	 * @param doneeType
	 */
	public void setDoneeType(DoneeType doneeType) {
		this.doneeType = Optional.of(doneeType);
	}

	/**
	 * 
	 * @param memberCount
	 */
	public void setMemberCount(Integer memberCount) {
		this.memberCount = Optional.of(memberCount);
	}

}
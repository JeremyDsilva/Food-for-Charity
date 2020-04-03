package com.foodforcharity.app.usecase.account.doneeregisteration;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class DoneeRegisterationCommand implements Command<Response<Void>> {
	String name;
	String password;
	String email;
	String phoneNumber;
	String city;
	String address;
	String country;
	DoneeType doneeType;
	Integer memberCount;

	/**
	 * @param name
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param city
	 * @param address
	 * @param country
	 * @param doneeType
	 * @param memberCount
	 */
	public DoneeRegisterationCommand(String name, String password, String email, String phoneNumber, String city,
			String address, String country, DoneeType doneeType, Integer memberCount) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
		this.country = country;
		this.doneeType = doneeType;
		this.memberCount = memberCount;
	}

}
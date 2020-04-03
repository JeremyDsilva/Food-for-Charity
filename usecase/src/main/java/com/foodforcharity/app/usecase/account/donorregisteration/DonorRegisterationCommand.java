package com.foodforcharity.app.usecase.account.donorregisteration;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

public class DonorRegisterationCommand implements Command<Response<Void>> {
	String name;
	String password;
	String email;
	String phoneNumber;
	String city;
	String address;
	String country;

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
	 * @param country;
	 */
	public DonorRegisterationCommand(String name, String password, String email, String phoneNumber, String city,
			String country, String address) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
		this.country = country;
	}

}
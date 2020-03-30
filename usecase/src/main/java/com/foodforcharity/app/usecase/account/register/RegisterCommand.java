package com.foodforcharity.app.usecase.account.register;

import java.util.Optional;

import com.foodforcharity.app.mediator.Command;

public class RegisterCommand implements Command<Void> {
	String name;
	String password;
	String email;
	String personRole;
	String phoneNumber;
	String city;
	String address;
	// only if registering as a donee
	// -> also why is the database type as string
	Optional<Integer> doneeTypeId;
	Optional<Integer> memberCount;

	public RegisterCommand() {

	}

}
package com.foodforcharity.app.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.constant.DonorStatus;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

/**
 * The persistent class for the DONOR database table.
 * 
 */
@Data
@Entity
@DiscriminatorValue("Donor")
public class Donor extends Person {
	private static final long serialVersionUID = 1L;

	@Column(name = "ADDRESS_DESCRIPTION")
	@NotNull
	private String addressDescription;

	@NotNull
	private String city;

	@NotNull
	private String country;

	@Column(name = "DONOR_NAME")
	@NotNull
	private String donorName;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@Column(name = "NUMBER_OF_RATING")
	@NotNull
	private Integer numberOfRating;

	@Column(name = "PHONE_NUMBER")
	@NotNull
	private String phoneNumber;

	@NotNull
	private Integer rating;

	@NotNull
	private Integer discountApplied; 

	// bi-directional many-to-one association to DonorStatus
	@Column(name = "DONOR_STATUS")
	@Enumerated(EnumType.STRING)
	@NotNull
	private DonorStatus donorStatus;

	// bi-directional many-to-one association to Food
	@OneToMany(mappedBy = "donor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Food> foods;

	// bi-directional many-to-one association to Request
	@OneToMany(mappedBy = "donor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Request> requests;

	
	public Food addFood(Food food) {
		if(getFoods() == null)
			setFoods(new ArrayList<Food>());
		getFoods().add(food);
		food.setDonor(this);

		return food;
	}

	public Food removeFood(Food food) {
		getFoods().remove(food);
		food.setDonor(null);

		return food;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setDonor(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setDonor(null);

		return request;
	}

	@Override
	public Optional<String> getStatus(){
		return Optional.of(donorStatus.name());
	}

}
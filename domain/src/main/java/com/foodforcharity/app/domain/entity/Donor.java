package com.foodforcharity.app.domain.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.convertor.DonorStatusConverter;
import com.foodforcharity.app.domain.security.PersonStatus;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the DONOR database table.
 * 
 */
@Entity
@PrimaryKeyJoinColumn
public class Donor extends Person {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="ADDRESS_DESCRIPTION")
	private String addressDescription;

	private String city;

	private String country;

	@Column(name="DONOR_NAME")
	private String donorName;

	private String email;

	@Column(name="NUMBER_OF_RATING")
	private Integer numberOfRating;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	private Integer rating;

	//bi-directional many-to-one association to DonorStatus
	// @ManyToOne
	@Column(name="DONOR_STATUS")
	@Convert(converter = DonorStatusConverter.class)
	private DonorStatus donorStatus;

	// // bi-directional many-to-one association to Person
	// @OneToOne
	// private Person person;

	//bi-directional many-to-one association to Food
	@OneToMany(mappedBy="donor", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Food> foods;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="donor", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Request> requests;

	public Donor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressDescription() {
		return this.addressDescription;
	}

	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDonorName() {
		return this.donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumberOfRating() {
		return this.numberOfRating;
	}

	public void setNumberOfRating(Integer numberOfRating) {
		this.numberOfRating = numberOfRating;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public DonorStatus getDonorStatus() {
		return this.donorStatus;
	}

	public void setDonorStatus(DonorStatus donorStatus) {
		this.donorStatus = donorStatus;
	}

	// public Person getPerson() {
	// 	return this.person;
	// }

	// public void setPerson(Person person) {
	// 	this.person = person;
	// }

	public List<Food> getFoods() {
		return this.foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Food addFood(Food food) {
		getFoods().add(food);
		food.setDonor(this);

		return food;
	}

	public Food removeFood(Food food) {
		getFoods().remove(food);
		food.setDonor(null);

		return food;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
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
	public Optional<PersonStatus> getPersonStatus() {
		return Optional.of(donorStatus);
	}

}
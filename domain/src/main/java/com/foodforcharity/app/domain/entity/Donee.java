package com.foodforcharity.app.domain.entity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.MealType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the DONEE database table.
 * 
 */
@Entity
@DiscriminatorValue("Donee")
public class Donee extends Person {
	private static final long serialVersionUID = 1L;

	@Column(name = "ADDRESS_DESCRIPTION")
	@NotNull
	private String addressDescription;

	@NotNull
	private String city;

	@NotNull
	private String country;

	@Column(name = "DONEE_NAME")
	@NotNull
	private String doneeName;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@Column(name = "MEMBER_COUNT")
	@NotNull
	private Integer memberCount;

	@Column(name = "PHONE_NUMBER")
	@NotNull
	private String phoneNumber;

	@Column(name = "QUANTITY_REQUESTED")
	@NotNull
	private Integer quantityRequested;

	@JoinColumn(name = "DONEE_STATUS")
	@Enumerated(EnumType.STRING)
	@NotNull
	private DoneeStatus doneeStatus;

	@JoinColumn(name = "DONEE_TYPE")
	@Enumerated(EnumType.STRING)
	@NotNull
	private DoneeType doneeType;

	// bi-directional many-to-one association to DoneePriceRange
	@OneToOne(mappedBy = "donee", fetch = FetchType.LAZY)
	private DoneePriceRange priceRange;

	// bi-directional many-to-one association to DoneeSpiceRange
	@OneToOne(mappedBy = "donee", fetch = FetchType.LAZY)
	private DoneeSpiceRange spiceRange;

	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Allergen.class)
	private Set<Allergen> allergens;

	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Cuisine.class)
	private Set<Cuisine> cuisines;

	// bi-directional many-to-one association to MapDoneeMealType
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = MealType.class)
	private Set<MealType> mealTypes;

	// bi-directional many-to-one association to Request
	@OneToMany(mappedBy = "donee", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Request> requests;

	public Donee() {
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

	public String getDoneeName() {
		return this.doneeName;
	}

	public void setDoneeName(String doneeName) {
		this.doneeName = doneeName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMemberCount() {
		return this.memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getQuantityRequested() {
		return this.quantityRequested;
	}

	public void setQuantityRequested(Integer quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public DoneeStatus getDoneeStatus() {
		return this.doneeStatus;
	}

	public void setDoneeStatus(DoneeStatus doneeStatus) {
		this.doneeStatus = doneeStatus;
	}

	public DoneeType getDoneeType() {
		return this.doneeType;
	}

	public void setDoneeType(DoneeType doneeType) {
		this.doneeType = doneeType;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setDonee(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setDonee(null);

		return request;
	}


	public Optional<String> getStatus(){
		return Optional.of(doneeStatus.name());
	}

	/**
	 * @return the priceRange
	 */
	public DoneePriceRange getPriceRange() {
		return priceRange;
	}

	/**
	 * @param priceRange the priceRange to set
	 */
	public void setPriceRange(DoneePriceRange priceRange) {
		this.priceRange = priceRange;
	}

	/**
	 * @return the spiceRange
	 */
	public DoneeSpiceRange getSpiceRange() {
		return spiceRange;
	}

	/**
	 * @param spiceRange the spiceRange to set
	 */
	public void setSpiceRange(DoneeSpiceRange spiceRange) {
		this.spiceRange = spiceRange;
	}

	/**
	 * @return the allergens
	 */
	public Set<Allergen> getAllergens() {
		return allergens;
	}

	/**
	 * @param allergens the allergens to set
	 */
	public void setAllergens(Set<Allergen> allergens) {
		this.allergens = allergens;
	}

	/**
	 * @return the cuisines
	 */
	public Set<Cuisine> getCuisines() {
		return cuisines;
	}

	/**
	 * @param cuisines the cuisines to set
	 */
	public void setCuisines(Set<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	/**
	 * @return the mealTypes
	 */
	public Set<MealType> getMealTypes() {
		return mealTypes;
	}

	/**
	 * @param mealTypes the mealTypes to set
	 */
	public void setMealTypes(Set<MealType> mealTypes) {
		this.mealTypes = mealTypes;
	}

}
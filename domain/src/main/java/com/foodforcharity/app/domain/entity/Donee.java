package com.foodforcharity.app.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * The persistent class for the DONEE database table.
 * 
 */
@Entity
@PrimaryKeyJoinColumn
public class Donee extends Person {
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private long id;

	@Column(name = "ADDRESS_DESCRIPTION")
	private String addressDescription;

	private String city;

	private String country;

	@Column(name = "DONEE_NAME")
	private String doneeName;

	private String email;

	@Column(name = "MEMBER_COUNT")
	private Integer memberCount;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "QUANTITY_REQUESTED")
	private Integer quantityRequested;

	// bi-directional many-to-one association to DoneeStatus
	@ManyToOne
	@JoinColumn(name = "DONEE_STATUS_ID")
	private DoneeStatus doneeStatus;

	// bi-directional many-to-one association to DoneeType
	@ManyToOne
	@JoinColumn(name = "DONEE_TYPE_ID")
	private DoneeType doneeType;

	// bi-directional many-to-one association to DoneePriceRange
	@OneToMany(mappedBy = "donee", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DoneePriceRange> doneePriceRanges;

	// bi-directional many-to-one association to DoneeSpiceRange
	@OneToMany(mappedBy = "donee", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DoneeSpiceRange> doneeSpiceRanges;

	// bi-directional many-to-one association to MapDoneeAllergen
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapDoneeAllergen", joinColumns = {
			@JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "AllergenId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Allergen> mapDoneeAllergens;

	// bi-directional many-to-one association to MapDoneeCuisine
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapDoneeCuisine", joinColumns = {
			@JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "CuisineId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cuisine> mapDoneeCuisines;

	// bi-directional many-to-one association to MapDoneeMealType
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapDoneeMealType", joinColumns = {
			@JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MealType> mapDoneeMealTypes;

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

	public List<DoneePriceRange> getDoneePriceRanges() {
		return this.doneePriceRanges;
	}

	public void setDoneePriceRanges(List<DoneePriceRange> doneePriceRanges) {
		this.doneePriceRanges = doneePriceRanges;
	}

	public DoneePriceRange addDoneePriceRange(DoneePriceRange doneePriceRange) {
		getDoneePriceRanges().add(doneePriceRange);
		doneePriceRange.setDonee(this);

		return doneePriceRange;
	}

	public DoneePriceRange removeDoneePriceRange(DoneePriceRange doneePriceRange) {
		getDoneePriceRanges().remove(doneePriceRange);
		doneePriceRange.setDonee(null);

		return doneePriceRange;
	}

	public List<DoneeSpiceRange> getDoneeSpiceRanges() {
		return this.doneeSpiceRanges;
	}

	public void setDoneeSpiceRanges(List<DoneeSpiceRange> doneeSpiceRanges) {
		this.doneeSpiceRanges = doneeSpiceRanges;
	}

	public DoneeSpiceRange addDoneeSpiceRange(DoneeSpiceRange doneeSpiceRange) {
		getDoneeSpiceRanges().add(doneeSpiceRange);
		doneeSpiceRange.setDonee(this);

		return doneeSpiceRange;
	}

	public DoneeSpiceRange removeDoneeSpiceRange(DoneeSpiceRange doneeSpiceRange) {
		getDoneeSpiceRanges().remove(doneeSpiceRange);
		doneeSpiceRange.setDonee(null);

		return doneeSpiceRange;
	}

	// public List<MapDoneeAllergen> getMapDoneeAllergens() {
	// 	return this.mapDoneeAllergens;
	// }

	// public void setMapDoneeAllergens(List<MapDoneeAllergen> mapDoneeAllergens) {
	// 	this.mapDoneeAllergens = mapDoneeAllergens;
	// }

	// public MapDoneeAllergen addMapDoneeAllergen(MapDoneeAllergen mapDoneeAllergen) {
	// 	getMapDoneeAllergens().add(mapDoneeAllergen);
	// 	mapDoneeAllergen.setDonee(this);

	// 	return mapDoneeAllergen;
	// }

	// public MapDoneeAllergen removeMapDoneeAllergen(MapDoneeAllergen mapDoneeAllergen) {
	// 	getMapDoneeAllergens().remove(mapDoneeAllergen);
	// 	mapDoneeAllergen.setDonee(null);

	// 	return mapDoneeAllergen;
	// }

	// public List<MapDoneeCuisine> getMapDoneeCuisines() {
	// 	return this.mapDoneeCuisines;
	// }

	// public void setMapDoneeCuisines(List<MapDoneeCuisine> mapDoneeCuisines) {
	// 	this.mapDoneeCuisines = mapDoneeCuisines;
	// }

	// public MapDoneeCuisine addMapDoneeCuisine(MapDoneeCuisine mapDoneeCuisine) {
	// 	getMapDoneeCuisines().add(mapDoneeCuisine);
	// 	mapDoneeCuisine.setDonee(this);

	// 	return mapDoneeCuisine;
	// }

	// public MapDoneeCuisine removeMapDoneeCuisine(MapDoneeCuisine mapDoneeCuisine) {
	// 	getMapDoneeCuisines().remove(mapDoneeCuisine);
	// 	mapDoneeCuisine.setDonee(null);

	// 	return mapDoneeCuisine;
	// }

	// public List<MapDoneeMealType> getMapDoneeMealTypes() {
	// 	return this.mapDoneeMealTypes;
	// }

	// public void setMapDoneeMealTypes(List<MapDoneeMealType> mapDoneeMealTypes) {
	// 	this.mapDoneeMealTypes = mapDoneeMealTypes;
	// }

	// public MapDoneeMealType addMapDoneeMealType(MapDoneeMealType mapDoneeMealType) {
	// 	getMapDoneeMealTypes().add(mapDoneeMealType);
	// 	mapDoneeMealType.setDonee(this);

	// 	return mapDoneeMealType;
	// }

	// public MapDoneeMealType removeMapDoneeMealType(MapDoneeMealType mapDoneeMealType) {
	// 	getMapDoneeMealTypes().remove(mapDoneeMealType);
	// 	mapDoneeMealType.setDonee(null);

	// 	return mapDoneeMealType;
	// }

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

}
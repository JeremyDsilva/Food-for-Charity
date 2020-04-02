package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the FOOD database table.
 * 
 */
@Entity
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "DESCRIPTION_TEXT")
	private String descriptionText;

	@Column(name = "FOOD_NAME")
	private String foodName;

	@Column(name = "MEAL_FOR_N_PEOPLE")
	private Integer mealForNPeople;

	private Integer price;

	@Column(name = "QUANTITY_AVAILABLE")
	private Integer quantityAvailable;

	// bi-directional many-to-one association to Donor
	@ManyToOne
	private Donor donor;

	// bi-directional many-to-one association to SpiceLevel
	// @ManyToOne
	@JoinColumn(name = "SPICE_LEVEL")
	// @Convert(converter = SpiceLevelStringConverter.class)
	@Enumerated(EnumType.STRING)
	private SpiceLevel spiceLevel;

	// bi-directional many-to-one association to MapFoodAllergen
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Allergen.class)
	private Set<Allergen> allergens;

	@Enumerated(EnumType.STRING)
	private Cuisine cuisines;

	// bi-directional many-to-one association to MapDoneeMealType
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = MealType.class)
	private Set<MealType> mealTypes;

	// bi-directional many-to-one association to Request
	@OneToMany(mappedBy = "donee", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Request> requests;

	// bi-directional many-to-one association to SubRequest
	@OneToMany(mappedBy = "food", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubRequest> subRequests;

	public Food() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescriptionText() {
		return this.descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getMealForNPeople() {
		return this.mealForNPeople;
	}

	public void setMealForNPeople(Integer mealForNPeople) {
		this.mealForNPeople = mealForNPeople;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantityAvailable() {
		return this.quantityAvailable;
	}

	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Donor getDonor() {
		return this.donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public List<SubRequest> getSubRequests() {
		return this.subRequests;
	}

	public void setSubRequests(List<SubRequest> subRequests) {
		this.subRequests = subRequests;
	}

	public SubRequest addSubRequest(SubRequest subRequest) {
		getSubRequests().add(subRequest);
		subRequest.setFood(this);

		return subRequest;
	}

	public SubRequest removeSubRequest(SubRequest subRequest) {
		getSubRequests().remove(subRequest);
		subRequest.setFood(null);

		return subRequest;
	}

}
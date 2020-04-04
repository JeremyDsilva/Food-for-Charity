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
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String descriptionText;

	@Column(name = "FOOD_NAME")
	@NotNull
	private String foodName;

	@Column(name = "MEAL_FOR_N_PEOPLE")
	@NotNull
	private Integer mealForNPeople;

	@NotNull
	private Integer price;

	@Column(name = "QUANTITY_AVAILABLE")
	@NotNull
	private Integer quantityAvailable;

	// bi-directional many-to-one association to Donor
	@ManyToOne
	@NotNull
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
	private Cuisine cuisine;

	// bi-directional many-to-one association to MapDoneeMealType
	@Enumerated(EnumType.STRING)
	private MealType mealType;

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

	/**
	 * @return the spiceLevel
	 */
	public SpiceLevel getSpiceLevel() {
		return spiceLevel;
	}

	/**
	 * @param spiceLevel the spiceLevel to set
	 */
	public void setSpiceLevel(SpiceLevel spiceLevel) {
		this.spiceLevel = spiceLevel;
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
	public Cuisine getCuisines() {
		return cuisine;
	}

	/**
	 * @param cuisines the cuisines to set
	 */
	public void setCuisines(Cuisine cuisines) {
		this.cuisine = cuisines;
	}

	/**
	 * @return the mealTypes
	 */
	public MealType getMealType() {
		return mealType;
	}

	/**
	 * @param mealTypes the mealTypes to set
	 */
	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	/**
	 * @param allergen
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addAllergen(Allergen allergen) {
		return allergens.add(allergen);
	}

	/**
	 * @param allergen
	 * @return
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeAllergen(Allergen allergen) {
		return allergens.remove(allergen);
	}

}
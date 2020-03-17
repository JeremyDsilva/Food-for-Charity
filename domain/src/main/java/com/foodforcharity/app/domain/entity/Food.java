package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

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
	@ManyToOne
	@JoinColumn(name = "SPICE_LEVEL")
	private SpiceLevel spiceLevel;

	// bi-directional many-to-one association to MapFoodAllergen
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapFoodAllergen", joinColumns = {
			@JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "AllergenId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Allergen> allergens;

	// bi-directional many-to-one association to MapFoodCuisine
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapFoodCuisine", joinColumns = {
			@JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "CuisineId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cuisine> mapFoodCuisines;

	// bi-directional many-to-one association to MapFoodMealType
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MapFoodMealType", joinColumns = {
			@JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MealType> mealTypes;

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

	// public SpiceLevel getSpiceLevelBean() {
	// return this.spiceLevelBean;
	// }

	// public void setSpiceLevelBean(SpiceLevel spiceLevelBean) {
	// this.spiceLevelBean = spiceLevelBean;
	// }

	// public List<MapFoodAllergen> getMapFoodAllergens() {
	// return this.mapFoodAllergens;
	// }

	// public void setMapFoodAllergens(List<MapFoodAllergen> mapFoodAllergens) {
	// this.mapFoodAllergens = mapFoodAllergens;
	// }

	// public MapFoodAllergen addMapFoodAllergen(MapFoodAllergen mapFoodAllergen) {
	// getMapFoodAllergens().add(mapFoodAllergen);
	// mapFoodAllergen.setFood(this);

	// return mapFoodAllergen;
	// }

	// public MapFoodAllergen removeMapFoodAllergen(MapFoodAllergen mapFoodAllergen)
	// {
	// getMapFoodAllergens().remove(mapFoodAllergen);
	// mapFoodAllergen.setFood(null);

	// return mapFoodAllergen;
	// }

	// public List<MapFoodCuisine> getMapFoodCuisines() {
	// return this.mapFoodCuisines;
	// }

	// public void setMapFoodCuisines(List<MapFoodCuisine> mapFoodCuisines) {
	// this.mapFoodCuisines = mapFoodCuisines;
	// }

	// public MapFoodCuisine addMapFoodCuisine(MapFoodCuisine mapFoodCuisine) {
	// getMapFoodCuisines().add(mapFoodCuisine);
	// mapFoodCuisine.setFood(this);

	// return mapFoodCuisine;
	// }

	// public MapFoodCuisine removeMapFoodCuisine(MapFoodCuisine mapFoodCuisine) {
	// getMapFoodCuisines().remove(mapFoodCuisine);
	// mapFoodCuisine.setFood(null);

	// return mapFoodCuisine;
	// }

	// public List<MapFoodMealType> getMapFoodMealTypes() {
	// return this.mapFoodMealTypes;
	// }

	// public void setMapFoodMealTypes(List<MapFoodMealType> mapFoodMealTypes) {
	// this.mapFoodMealTypes = mapFoodMealTypes;
	// }

	// public MapFoodMealType addMapFoodMealType(MapFoodMealType mapFoodMealType) {
	// getMapFoodMealTypes().add(mapFoodMealType);
	// mapFoodMealType.setFood(this);

	// return mapFoodMealType;
	// }

	// public MapFoodMealType removeMapFoodMealType(MapFoodMealType mapFoodMealType)
	// {
	// getMapFoodMealTypes().remove(mapFoodMealType);
	// mapFoodMealType.setFood(null);

	// return mapFoodMealType;
	// }

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
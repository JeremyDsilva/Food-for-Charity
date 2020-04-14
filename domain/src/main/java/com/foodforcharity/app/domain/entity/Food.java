package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import lombok.Data;

/**
 * The persistent class for the FOOD database table.
 * 
 */
@Data
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
	@NotNull
	private MealType mealType;

	// bi-directional many-to-one association to SubRequest
	@OneToMany(mappedBy = "food", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubRequest> subRequests;

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
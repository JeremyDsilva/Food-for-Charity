package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * The persistent class for the ALLERGEN database table.
 * 
 */
@Entity
public class Allergen implements Serializable {
	private static final long serialVersionUID = 1L;

	static public enum Value {
        Dairy, Nuts, Seafood, Wheat, Soybeans, Gluten;
    }

	@Id
	@Column(name = "id")
	private String name;

	// bi-directional many-to-one association to MapDoneeAllergen
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="MapDoneeAllergen", joinColumns={
		@JoinColumn(name="AllergenId",referencedColumnName="id")}
		,inverseJoinColumns = {
					 @JoinColumn(name = "DoneeId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Donee> donees;

	// bi-directional many-to-one association to MapFoodAllergen
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="MapFoodAllergen", joinColumns={
		@JoinColumn(name="AllergenId",referencedColumnName="id")}
		,inverseJoinColumns = {
					 @JoinColumn(name = "FoodId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Food> foods;

	public Allergen() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
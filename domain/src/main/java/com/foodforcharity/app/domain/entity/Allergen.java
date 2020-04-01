package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;

import com.foodforcharity.app.domain.convertor.AllergenStringConverter;
import com.foodforcharity.app.domain.convertor.ConstantEntity;

/**
 * The persistent class for the ALLERGEN database table.
 * 
 */
@Entity
public class Allergen extends ConstantEntity<com.foodforcharity.app.domain.constant.Allergen> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Allergen() {
		super(new AllergenStringConverter(), Arrays.asList(com.foodforcharity.app.domain.constant.Allergen.values()));
	}

	public Allergen(com.foodforcharity.app.domain.constant.Allergen allergen) {
		this();
		setConstant(allergen);
	}

	// // bi-directional many-to-one association to MapDoneeAllergen
	// @OneToMany(fetch=FetchType.LAZY)
	// @JoinTable(name="MapDoneeAllergen", joinColumns={
	// 	@JoinColumn(name="AllergenId",referencedColumnName="id")}
	// 	,inverseJoinColumns = {
	// 				 @JoinColumn(name = "DoneeId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Donee> donees;

	// // bi-directional many-to-one association to MapFoodAllergen
	// @OneToMany(fetch=FetchType.LAZY)
	// @JoinTable(name="MapFoodAllergen", joinColumns={
	// 	@JoinColumn(name="AllergenId",referencedColumnName="id")}
	// 	,inverseJoinColumns = {
	// 				 @JoinColumn(name = "FoodId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Food> foods;



	// public Allergen() {
	// }

	// public String getName() {
	// 	return this.name;
	// }

	// public void setName(String name) {
	// 	this.name = name;
	// }

}
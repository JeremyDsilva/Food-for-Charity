package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodforcharity.app.domain.convertor.ConstantEntity;
import com.foodforcharity.app.domain.convertor.SpiceLevelStringConverter;


/**
 * The persistent class for the SPICE_LEVEL database table.
 * 
 */
@Entity
@Table(name="SPICE_LEVEL")
public class SpiceLevel extends ConstantEntity<com.foodforcharity.app.domain.constant.SpiceLevel> implements Serializable {
	private static final long serialVersionUID = 1L;

	// //bi-directional many-to-one association to DoneeSpiceRange
	// @OneToMany(mappedBy="startLevel", fetch=FetchType.EAGER)
	// private List<DoneeSpiceRange> doneeStartSpice;

	// //bi-directional many-to-one association to DoneeSpiceRange
	// @OneToMany(mappedBy="endLevel", fetch=FetchType.EAGER)
	// private List<DoneeSpiceRange> doneeEndSpice;

	// //bi-directional many-to-one association to Food
	// @OneToMany(mappedBy="spiceLevel", fetch=FetchType.LAZY)
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Food> foods;

	public SpiceLevel(){
		super(new SpiceLevelStringConverter());
	}

	public SpiceLevel(com.foodforcharity.app.domain.constant.SpiceLevel spiceLevel) {
		this();
		setConstant(spiceLevel);
	}	


	// public List<DoneeSpiceRange> getDoneeSpiceRanges1() {
	// 	return this.doneeSpiceRanges1;
	// }

	// public void setDoneeSpiceRanges1(List<DoneeSpiceRange> doneeSpiceRanges1) {
	// 	this.doneeSpiceRanges1 = doneeSpiceRanges1;
	// }

	// public DoneeSpiceRange addDoneeSpiceRanges1(DoneeSpiceRange doneeSpiceRanges1) {
	// 	getDoneeSpiceRanges1().add(doneeSpiceRanges1);
	// 	doneeSpiceRanges1.setStartLevel(this);

	// 	return doneeSpiceRanges1;
	// }

	// public DoneeSpiceRange removeDoneeSpiceRanges1(DoneeSpiceRange doneeSpiceRanges1) {
	// 	getDoneeSpiceRanges1().remove(doneeSpiceRanges1);
	// 	doneeSpiceRanges1.setStartLevel(null);

	// 	return doneeSpiceRanges1;
	// }

	// public List<DoneeSpiceRange> getDoneeSpiceRanges2() {
	// 	return this.doneeSpiceRanges2;
	// }

	// public void setDoneeSpiceRanges2(List<DoneeSpiceRange> doneeSpiceRanges2) {
	// 	this.doneeSpiceRanges2 = doneeSpiceRanges2;
	// }

	// public DoneeSpiceRange addDoneeSpiceRanges2(DoneeSpiceRange doneeSpiceRanges2) {
	// 	getDoneeSpiceRanges2().add(doneeSpiceRanges2);
	// 	doneeSpiceRanges2.setEndLevel(this);

	// 	return doneeSpiceRanges2;
	// }

	// public DoneeSpiceRange removeDoneeSpiceRanges2(DoneeSpiceRange doneeSpiceRanges2) {
	// 	getDoneeSpiceRanges2().remove(doneeSpiceRanges2);
	// 	doneeSpiceRanges2.setEndLevel(null);

	// 	return doneeSpiceRanges2;
	// }

	// public List<Food> getFoods() {
	// 	return this.foods;
	// }

	// public void setFoods(List<Food> foods) {
	// 	this.foods = foods;
	// }

	// public Food addFood(Food food) {
	// 	getFoods().add(food);
	// 	food.setSpiceLevelBean(this);

	// 	return food;
	// }

	// public Food removeFood(Food food) {
	// 	getFoods().remove(food);
	// 	food.setSpiceLevelBean(null);

	// 	return food;
	// }

}
package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodforcharity.app.domain.convertor.ConstantEntity;
import com.foodforcharity.app.domain.convertor.MealTypeStringConverter;


/**
 * The persistent class for the MEAL_TYPE database table.
 * 
 */
@Entity
@Table(name="MEAL_TYPE")
public class MealType extends ConstantEntity<com.foodforcharity.app.domain.constant.MealType> implements Serializable {
	private static final long serialVersionUID = 1L;


	// // bi-directional many-to-one association to MapDoneeMealType
	// @OneToMany(fetch=FetchType.LAZY)
	// @JoinTable(name="MapDoneeMealType", joinColumns={
	// 	@JoinColumn(name="MealTypeId",referencedColumnName="id")}
	// 	,inverseJoinColumns = {
	// 				 @JoinColumn(name = "DoneeId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Donee> donees;

	// // bi-directional many-to-one association to MapFoodMealType
	// @OneToMany(fetch=FetchType.LAZY)
	// @JoinTable(name="MapFoodMealType", joinColumns={
	// 	@JoinColumn(name="MealTypeId",referencedColumnName="id")}
	// 	,inverseJoinColumns = {
	// 				 @JoinColumn(name = "FoodId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Food> foods;

	
	public MealType() {
		super(new MealTypeStringConverter());
	}

	public MealType(com.foodforcharity.app.domain.constant.MealType mealType) {
		this();
		setConstant(mealType);
	}

	// public List<MapDoneeMealType> getMapDoneeMealTypes() {
	// 	return this.mapDoneeMealTypes;
	// }

	// public void setMapDoneeMealTypes(List<MapDoneeMealType> mapDoneeMealTypes) {
	// 	this.mapDoneeMealTypes = mapDoneeMealTypes;
	// }

	// public MapDoneeMealType addMapDoneeMealType(MapDoneeMealType mapDoneeMealType) {
	// 	getMapDoneeMealTypes().add(mapDoneeMealType);
	// 	mapDoneeMealType.setMealType(this);

	// 	return mapDoneeMealType;
	// }

	// public MapDoneeMealType removeMapDoneeMealType(MapDoneeMealType mapDoneeMealType) {
	// 	getMapDoneeMealTypes().remove(mapDoneeMealType);
	// 	mapDoneeMealType.setMealType(null);

	// 	return mapDoneeMealType;
	// }

	// public List<MapFoodMealType> getMapFoodMealTypes() {
	// 	return this.mapFoodMealTypes;
	// }

	// public void setMapFoodMealTypes(List<MapFoodMealType> mapFoodMealTypes) {
	// 	this.mapFoodMealTypes = mapFoodMealTypes;
	// }

	// public MapFoodMealType addMapFoodMealType(MapFoodMealType mapFoodMealType) {
	// 	getMapFoodMealTypes().add(mapFoodMealType);
	// 	mapFoodMealType.setMealType(this);

	// 	return mapFoodMealType;
	// }

	// public MapFoodMealType removeMapFoodMealType(MapFoodMealType mapFoodMealType) {
	// 	getMapFoodMealTypes().remove(mapFoodMealType);
	// 	mapFoodMealType.setMealType(null);

	// 	return mapFoodMealType;
	// }

}
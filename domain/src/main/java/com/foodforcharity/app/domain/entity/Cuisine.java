package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import com.foodforcharity.app.domain.convertor.ConstantEntity;
import com.foodforcharity.app.domain.convertor.CuisineStringConverter;

/**
 * The persistent class for the CUISINE database table.
 * 
 */
@Entity
public class Cuisine extends ConstantEntity<com.foodforcharity.app.domain.constant.Cuisine> implements Serializable {
	private static final long serialVersionUID = 1L;

	// // bi-directional many-to-one association to MapDoneeCuisine
	// @OneToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "MapDoneeCuisine", joinColumns = {
	// 		@JoinColumn(name = "CuisineId", referencedColumnName = "id") }, inverseJoinColumns = {
	// 				@JoinColumn(name = "DoneeId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Donee> donees;

	// // bi-directional many-to-one association to MapFoodCuisine
	// @OneToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "MapFoodCuisine", joinColumns = {
	// 		@JoinColumn(name = "CuisineId", referencedColumnName = "id") }, inverseJoinColumns = {
	// 				@JoinColumn(name = "FoodId", referencedColumnName = "id") })
	// @Fetch(value = FetchMode.SUBSELECT)
	// private List<Food> foods;

	public Cuisine(){
		super(new CuisineStringConverter());
	}

	public Cuisine(com.foodforcharity.app.domain.constant.Cuisine cuisine) {
		this();
		setConstant(cuisine);
	}	

	// public List<MapDoneeCuisine> getMapDoneeCuisines() {
	// return this.mapDoneeCuisines;
	// }

	// public void setMapDoneeCuisines(List<MapDoneeCuisine> mapDoneeCuisines) {
	// this.mapDoneeCuisines = mapDoneeCuisines;
	// }

	// public MapDoneeCuisine addMapDoneeCuisine(MapDoneeCuisine mapDoneeCuisine) {
	// getMapDoneeCuisines().add(mapDoneeCuisine);
	// mapDoneeCuisine.setCuisine(this);

	// return mapDoneeCuisine;
	// }

	// public MapDoneeCuisine removeMapDoneeCuisine(MapDoneeCuisine mapDoneeCuisine)
	// {
	// getMapDoneeCuisines().remove(mapDoneeCuisine);
	// mapDoneeCuisine.setCuisine(null);

	// return mapDoneeCuisine;
	// }

	// public List<MapFoodCuisine> getMapFoodCuisines() {
	// return this.mapFoodCuisines;
	// }

	// public void setMapFoodCuisines(List<MapFoodCuisine> mapFoodCuisines) {
	// this.mapFoodCuisines = mapFoodCuisines;
	// }

	// public MapFoodCuisine addMapFoodCuisine(MapFoodCuisine mapFoodCuisine) {
	// getMapFoodCuisines().add(mapFoodCuisine);
	// mapFoodCuisine.setCuisine(this);

	// return mapFoodCuisine;
	// }

	// public MapFoodCuisine removeMapFoodCuisine(MapFoodCuisine mapFoodCuisine) {
	// getMapFoodCuisines().remove(mapFoodCuisine);
	// mapFoodCuisine.setCuisine(null);

	// return mapFoodCuisine;
	// }

}
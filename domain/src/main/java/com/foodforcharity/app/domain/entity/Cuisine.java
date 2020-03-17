package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * The persistent class for the CUISINE database table.
 * 
 */
@Entity
public class Cuisine implements Serializable {
	private static final long serialVersionUID = 1L;

	static public enum Value  {
        Italian, Chinese, Indian, Thai, Mongolian, Japanese, Arab, French, Spanish, Mexican, Indonasian, Philapino, Greek, Portugal, Hawaain, Brazilian, Vietnam, Turkish, Belgravian, NoPreference;
    }

	@Id
	private String name;

	// bi-directional many-to-one association to MapDoneeCuisine
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MapDoneeCuisine", joinColumns = {
			@JoinColumn(name = "CuisineId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "DoneeId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Donee> donees;

	// bi-directional many-to-one association to MapFoodCuisine
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MapFoodCuisine", joinColumns = {
			@JoinColumn(name = "CuisineId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "FoodId", referencedColumnName = "id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Food> foods;

	public Cuisine() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
package com.foodforcharity.api.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Food", schema = "b00074902")
public class Food {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private long id;

  @Column(name = "FoodName")
  String foodName;

  @Column(name = "DescriptionText")
  String descriptionText;

  @Column(name = "Price")
  int price;

  @Column(name = "QuantityAvailable")
  int quantityAvailable;

  @ManyToOne(fetch = FetchType.LAZY)
  Donor donor;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapFoodAllergen", joinColumns = {
      @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "AllergenId", referencedColumnName = "id") })
  List<Allergen> allergens;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapFoodMealType", joinColumns = {
      @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
  List<MealType> mealTypes;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapFoodCuisine", joinColumns = {
      @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "CuisineId", referencedColumnName = "id") })
  List<Cuisine> cuisines;

  // CONSTRAINT fk_Food_DonorId FOREIGN KEY(DonorId) REFERENCES
  // b00074902.Donor(Id)
}

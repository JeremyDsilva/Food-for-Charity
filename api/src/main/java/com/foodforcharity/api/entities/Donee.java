package com.foodforcharity.api.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Donee", schema = "b00074902")
public class Donee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "DoneeName")
  String doneeName;

  @Column(name = "PhoneNumber")
  String phoneNumber;

  @Column(name = "Email")
  String email;

  @Column(name = "AddressDescription")
  String addressDescription;

  @Column(name = "City")
  String city;

  @Column(name = "Country")
  String country;

  @OneToOne
  DoneeStatus doneeStatus;

  @OneToOne
  DoneeType doneeType;

  @Column(name = "MemberCount")
  int memberCount;

  @Column(name = "QuantityRequested")
  int quantityRequested;

  @OneToOne
  Person person;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeAllergen", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "AllergenId", referencedColumnName = "id") })
  List<Allergen> allergens;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeMealType", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
  List<MealType> mealTypes;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeCuisine", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "CuisineId", referencedColumnName = "id") })
  List<Cuisine> cuisines;

  @OneToOne
  @JoinColumn(name = "Id", referencedColumnName = "DoneeId")
  DoneePriceRange priceRange;

  @OneToOne
  @JoinColumn(name = "Id", referencedColumnName = "DoneeId")
  DoneeSpiceRange spiceRange;

}

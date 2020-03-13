package com.foodforcharity.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Donee", schema = "b00074902")
@PrimaryKeyJoinColumn(name = "PersonId")
public class Donee extends Person {
  // @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long doneeId;

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

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeAllergen", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "AllergenId", referencedColumnName = "id") })
  @Fetch(value = FetchMode.SUBSELECT)
  List<Allergen> allergens;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeMealType", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
  @Fetch(value = FetchMode.SUBSELECT)
  List<MealType> mealTypes;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapDoneeCuisine", joinColumns = {
      @JoinColumn(name = "DoneeId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "CuisineId", referencedColumnName = "id") })
  @Fetch(value = FetchMode.SUBSELECT)
  List<Cuisine> cuisines;

  @OneToOne
  @JoinColumn(name = "Id", referencedColumnName = "DoneeId")
  DoneePriceRange priceRange;

  @OneToOne
  @JoinColumn(name = "Id", referencedColumnName = "DoneeId")
  DoneeSpiceRange spiceRange;

}

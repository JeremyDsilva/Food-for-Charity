package com.foodforcharity.api.entities;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

        @Column(name = "DonorId")
        public long donorId;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(name = "MapFoodAllergen", joinColumns = {
                        @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "AllergenId", referencedColumnName = "id") })
        @Fetch(value = FetchMode.SUBSELECT)
        List<Allergen> allergens;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(name = "MapFoodMealType", joinColumns = {
                        @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "MealTypeId", referencedColumnName = "id") })
        @Fetch(value = FetchMode.SUBSELECT)
        List<MealType> mealTypes;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(name = "MapFoodCuisine", joinColumns = {
                        @JoinColumn(name = "FoodId", referencedColumnName = "id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "CuisineId", referencedColumnName = "id") })
        @Fetch(value = FetchMode.SUBSELECT)
        List<Cuisine> cuisines;

}

package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapFoodAllergen")
public class MapFoodAllergen {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="FoodId")
    Food food;

    @OneToOne(mappedBy="AllergenId")
    Allergen allergen;

    // CONSTRAINT fk_MapFoodAllergen_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id);
    // CONSTRAINT fk_MapFoodAllergen_AllergenId FOREIGN KEY(AllergenId) REFERENCES b00074902.Allergen(Id)
}


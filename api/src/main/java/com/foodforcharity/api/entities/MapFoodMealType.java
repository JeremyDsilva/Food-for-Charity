package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapFoodMealType")
public class MapFoodMealType {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="FoodId")
    Food food;

    @OneToOne(mappedBy = "MealTypeId")
    MealType mealType ;


    // CONSTRAINT fk_MapFoodMealType_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id);
    // CONSTRAINT fk_MapFoodMealType_MealTypeId FOREIGN KEY(MealTypeId) REFERENCES b00074902.MealType(Id)
}


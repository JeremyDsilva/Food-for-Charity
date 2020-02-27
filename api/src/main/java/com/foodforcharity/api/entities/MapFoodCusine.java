package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapFoodCusine")
public class MapFoodCusine {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="FoodId")
    Food food;

    @OneToOne(mappedBy="CusineId")
    Cusine cusine;

    // CONSTRAINT fk_MapFoodCusine_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id);
    // CONSTRAINT fk_MapFoodCusine_CusineId FOREIGN KEY(CusineId) REFERENCES b00074902.Cusine(Id)
}


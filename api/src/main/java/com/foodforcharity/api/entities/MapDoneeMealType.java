package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapDoneeMealType")
public class MapDoneeMealType {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="DoneeId")
    Donor donor;

    @OneToOne(mappedBy = "MealTypeId")
    MealType mealType;

    // CONSTRAINT fk_MapDoneeMealType_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id);
    // CONSTRAINT fk_MapDoneeMealType_MealTypeId FOREIGN KEY(MealTypeId) REFERENCES b00074902.MealType(Id)
}


package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.Food")
public class Food {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="FoodName")
    String foodName;

    @Column(name = "DescriptionText")
    String descriptionText;

    @Column(name = "Price")
    int price;

    @Column(name = "QuantityAvailable")
    int quantityAvailable;

    @OneToOne(mappedBy = "DonorId")
    Donor donor;

    // CONSTRAINT fk_Food_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id)
}


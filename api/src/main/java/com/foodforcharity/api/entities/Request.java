package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="b00074902.Request")
public class Request {
    @Id
    @GeneratedValue
    private Integer id;
    int FoodId;

    @OneToOne(mappedBy = "DoneeId")
    Donor donor;

    @Column(name = "Quantity")
    int quantity;

    @Column(name = "RequestTime")
    Date requestTime ;

    // CONSTRAINT fk_Request_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id);
    // CONSTRAINT fk_Request_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id)
}


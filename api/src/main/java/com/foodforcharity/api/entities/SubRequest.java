package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "SubRequest", schema = "b00074902")
public class SubRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @OneToOne
    Food food;

    @Column(name = "PriceAtPurchase")
    int priceAtPurchase;

    @Column(name = "Quantity")
    int quantity;

    @ManyToOne
    Request request;

}

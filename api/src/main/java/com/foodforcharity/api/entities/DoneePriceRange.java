package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "DoneePriceRange", schema = "b00074902")
public class DoneePriceRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "DoneeId")
    private Integer doneeId;

    @Column(name = "StartPrice")
    private int startPrice;

    @Column(name = "EndPrice")
    private int endPrice;

}

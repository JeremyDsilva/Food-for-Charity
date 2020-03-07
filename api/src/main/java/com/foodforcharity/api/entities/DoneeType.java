package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "DoneeType", schema = "b00074902")
public class DoneeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    String name;

}

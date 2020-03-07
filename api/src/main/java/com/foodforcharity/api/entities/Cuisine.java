package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "Cuisine", schema = "b00074902")
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    private String name;

}

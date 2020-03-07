package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "Allergen", schema = "b00074902")
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Name")
    private String name;

}

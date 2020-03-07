package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "MealType", schema = "b00074902")
public class MealType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    String name;

}

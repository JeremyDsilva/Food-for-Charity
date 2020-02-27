package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "b00074902.MealType")
public class MealType {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "Name")
    String name;

}

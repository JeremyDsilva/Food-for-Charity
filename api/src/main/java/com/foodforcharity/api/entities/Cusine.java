package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.Cusine")
public class Cusine {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name="Name")
    String name;     
}


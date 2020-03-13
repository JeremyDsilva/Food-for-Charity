package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "PersonRole", schema = "b00074902")
public class PersonRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    String name;

}

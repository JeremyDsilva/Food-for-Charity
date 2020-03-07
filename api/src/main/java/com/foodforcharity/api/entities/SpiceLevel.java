package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "SpiceLevel", schema = "b00074902")
public class SpiceLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Name")
    private String name;

    public SpiceLevel(String name){
        this.name = name;
    }

    public SpiceLevel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    };

}

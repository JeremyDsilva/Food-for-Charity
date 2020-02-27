package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "b00074902.Allergen")
public class Allergen {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "Name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

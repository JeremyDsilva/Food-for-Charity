package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "DoneeSpiceRange", schema = "b00074902")
public class DoneeSpiceRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "DoneeId")
    private Integer doneeId;

    @Column(name = "StartLevel")
    private int startLevel;

    @Column(name = "EndLevel")
    private int endLevel;

}

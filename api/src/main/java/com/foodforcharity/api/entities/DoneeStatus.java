package com.foodforcharity.api.entities;

import javax.persistence.*;

import com.foodforcharity.api.entities.convertors.BooleanCharacterConverter;

@Entity
@Table(name = "DoneeStatus", schema = "b00074902")
public class DoneeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    String name;

    @Column(name = "HasAccess")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean hasAccess;
}

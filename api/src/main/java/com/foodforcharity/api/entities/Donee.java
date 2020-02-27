package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "b00074902.Donee")
public class Donee {
    @Id
    private Integer id;

    @Column(name = "DoneeName")
    String doneeName;

    @Column(name = "PhoneNumber")
    int phoneNumber;

    @Column(name = "Street")
    String street;

    @Column(name = "Area")
    String area;

    @Column(name = "City")
    String city;

    @Column(name = "Country")
    String country;

    @OneToOne(mappedBy = "StatusId")
    DoneeStatus doneeStatus;

    @OneToOne(mappedBy = "TypeId")
    DoneeType type;

    @OneToOne(mappedBy = "MemberCount")
    int memberCount;

    @OneToOne(mappedBy = "QuantityOrdered")
    int quantityOrdered;

    @OneToOne(mappedBy = "id")
    Person person;

}

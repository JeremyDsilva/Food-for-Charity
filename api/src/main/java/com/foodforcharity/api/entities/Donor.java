package com.foodforcharity.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Donor", schema = "b00074902")
@PrimaryKeyJoinColumn(name = "PersonId")
public class Donor extends Person {
    // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public long donorId;

    @Column(name = "DonorName")
    String donorName;

    @Column(name = "PhoneNumber")
    String phoneNumber;

    @Column(name = "Email")
    String email;

    @Column(name = "AddressDescription")
    String addressDescription;

    @Column(name = "City")
    String city;

    @Column(name = "Country")
    String country;

    @Column(name = "Rating")
    int rating;

    @Column(name = "NumberOfRating")
    int numberOfRating;

    @OneToOne
    DonorStatus donorStatus;
    
}

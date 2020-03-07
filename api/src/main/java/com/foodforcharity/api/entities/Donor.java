package com.foodforcharity.api.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Donor", schema = "b00074902")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

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

    @OneToOne
    Person person;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    List<Food> menu;

}

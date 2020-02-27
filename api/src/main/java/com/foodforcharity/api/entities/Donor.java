package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "b00074902.Donor")
public class Donor {
    @Id
    private Integer id;
    @Column(name = "DonorName")
    String donorName;

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

    @Column(name = "Rating")
    int rating;

    @Column(name = "NumberOfRating")
    int numberOfRating;
    
    @OneToOne(mappedBy ="statusId")
    DonorStatus status;

    @OneToOne(mappedBy = "id")
    Person person;

    // CONSTRAINT fk_Donor_Id FOREIGN KEY(Id) REFERENCES b00074902.Person(Id);
    // CONSTRAINT fk_Donor_StatusId FOREIGN KEY(StatusId) REFERENCES
    // b00074902.DonorStatus(Id)
}

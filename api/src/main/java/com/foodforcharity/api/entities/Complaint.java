package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.*;

import com.foodforcharity.api.entities.convertors.BooleanCharacterConverter;

@Entity
@Table(name = "Complaint", schema = "b00074902")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @OneToOne
    Request request;

    @Column(name = "DescriptionText")
    String descriptionText;

    @Column(name = "ComplaintTime")
    Date complaintTime;

    @Column(name = "FromDonee")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean fromDonee;

    @Column(name = "IsActive")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean isActive;

}

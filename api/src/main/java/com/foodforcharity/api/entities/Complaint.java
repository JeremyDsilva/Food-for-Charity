package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.foodforcharity.api.entities.convertors.BooleanCharacterConverter;

@Entity
@Table(name = "Complaint", schema = "b00074902")
public class Complaint {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    Request request;

    @Column(name = "descriptionText")
    String descriptionText;

    @Column(name = "complaintTime")
    Date complaintTime;

    @Column(name = "FromDonee")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean fromDonee;

    @Column(name = "IsActive")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean isActive;

}

package com.foodforcharity.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.foodforcharity.api.entities.convertors.BooleanCharacterConverter;

@Entity
@Table(name = "Request", schema = "b00074902")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @OneToOne
    @JoinColumn(name = "DonorId", referencedColumnName = "id")
    Donor donor;

    @OneToOne
    @JoinColumn(name = "DoneeId", referencedColumnName = "id")
    Donee donee;

    @Column(name = "FinalPrice")
    int finalPrice;

    @Column(name = "DiscountApplied")
    int discountApplied;

    @Column(name = "RequestTime")
    Date requestTime;

    @Column(name = "IsActive")
    @Convert(converter = BooleanCharacterConverter.class)
    Boolean IsActive;

    @OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SubRequest> subRequest;

}

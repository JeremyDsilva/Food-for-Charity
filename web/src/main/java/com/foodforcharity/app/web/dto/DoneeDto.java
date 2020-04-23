package com.foodforcharity.app.web.dto;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.entity.Donee;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class DoneeDto {

    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String addressDescription;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Integer memberCount;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Integer quantityRequested;

    @NotNull
    private DoneeStatus status;

    @NotNull
    private DoneeType type;

    public DoneeDto(Donee donee) {
        this.id = donee.getId();
        this.addressDescription = donee.getAddressDescription();
        this.city = donee.getCity();
        this.country = donee.getCountry();
        this.city = donee.getCity();
        this.email = donee.getEmail();
        this.memberCount = donee.getMemberCount();
        this.quantityRequested = donee.getQuantityRequested();
        this.status = donee.getDoneeStatus();
        this.type = donee.getDoneeType();
        this.phoneNumber = donee.getPhoneNumber();
    }


}
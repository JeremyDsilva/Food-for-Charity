package com.foodforcharity.app.web.dto;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.entity.Donor;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DonorDto {

    private long id;

    private String name;

    private String addressDescription;

    private String city;

    private String country;

    private String email;

    private Integer rating;

    private Integer discountApplied;

    private DonorStatus donorStatus;

    private List<FoodDto> foods;

    public DonorDto(Donor donor) {
        this.id = donor.getId();
        this.addressDescription = donor.getAddressDescription();
        this.city = donor.getCity();
        this.country = donor.getCountry();
        this.discountApplied = donor.getDiscountApplied();
        this.name = donor.getDonorName();
        this.donorStatus = donor.getDonorStatus();
        this.email = donor.getEmail();

        if (donor.getFoods() != null)
            this.foods = donor.getFoods().stream().map(food -> new FoodDto(food)).collect(Collectors.toList());
        else
            this.foods = Collections.emptyList();

        this.rating = donor.getNumberOfRating() != 0 ? donor.getRating() / donor.getNumberOfRating() : -1;
    }


}
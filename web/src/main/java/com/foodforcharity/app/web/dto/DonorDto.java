package com.foodforcharity.app.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.entity.Donor;

import lombok.Data;

@Data
public class DonorDto {

    private long id;

    private String donorName;

    private String addressDescription;

    private String city;

    private String country;

    private String email;

    private Integer rating;
    
    private Integer discountApplied;

    private DonorStatus donorStatus;

    private List<FoodDto> foods;

    public DonorDto(Donor donor){
        this.id = donor.getId();
        this.addressDescription = donor.getAddressDescription();
        this.city = donor.getCity();
        this.country = donor.getCountry();
        this.discountApplied = donor.getDiscountApplied();
        this.donorName = donor.getDonorName();
        this.donorStatus = donor.getDonorStatus();
        this.email = donor.getEmail();

        this.foods = donor.getFoods().stream().map(food -> new FoodDto(food)).collect(Collectors.toList());
        this.foods.forEach(food -> food.setPrice(food.getPrice() * getDiscountApplied()/100));
        
        this.rating = donor.getNumberOfRating() != 0? donor.getRating() / donor.getNumberOfRating() : -1;
    }
    

}
package com.foodforcharity.app.domain;

import java.util.List;

import com.foodforcharity.common.Enum.DonorStatus;

public class Donor {

    long id;

    String donorName;

    String phoneNumber;

    String email;

    String addressDescription;

    String city;

    String country;

    int rating;

    int numberOfRating;

    DonorStatus donorStatus;

    Person person;

    List<Food> menu;

}

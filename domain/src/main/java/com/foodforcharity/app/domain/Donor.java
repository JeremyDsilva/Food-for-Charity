package com.foodforcharity.app.domain;

import com.foodforcharity.common.Authority.DonorStatus;

public class Donor extends Person {
    
    public long donorId;

    String donorName;

    String phoneNumber;

    String email;

    String addressDescription;

    String city;

    String country;

    int rating;

    int numberOfRating;

    DonorStatus donorStatus;
    
}

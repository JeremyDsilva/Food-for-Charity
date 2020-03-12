package com.foodforcharity.app.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.foodforcharity.common.Authority;
import com.foodforcharity.common.Authority.DonorStatus;
import com.foodforcharity.common.Authority.PersonRole;

import org.springframework.security.core.GrantedAuthority;

public class Donor extends Person {

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

    List<Food> menu;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new Authority(PersonRole.Donor, donorStatus));
    }

}

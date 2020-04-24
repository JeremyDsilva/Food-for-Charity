package com.foodforcharity.app.domain.service;

import com.foodforcharity.app.domain.entity.Donor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DonorService extends Service<Donor> {
    List<Donor> findByDonorName(String donorName);

    Optional<Donor> findByUsername(String username);
}
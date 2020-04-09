package com.foodforcharity.app.domain.service;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.domain.entity.Donee;

import org.springframework.stereotype.Component;

@Component
public interface DoneeService extends Service<Donee> {
    
    List<Donee> findByDoneeName(String doneeName);

    Optional<Donee> findByUsername(String username);

}
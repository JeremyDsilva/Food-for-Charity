package com.foodforcharity.app.domain.service;

import com.foodforcharity.app.domain.entity.Donee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DoneeService extends Service<Donee> {

    List<Donee> findByDoneeName(String doneeName);

    Optional<Donee> findByUsername(String username);

}
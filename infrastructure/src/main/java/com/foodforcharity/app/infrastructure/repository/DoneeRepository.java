package com.foodforcharity.app.infrastructure.repository;

import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.service.DoneeService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneeRepository extends CrudRepository<Donee, Long>, DoneeService {
}
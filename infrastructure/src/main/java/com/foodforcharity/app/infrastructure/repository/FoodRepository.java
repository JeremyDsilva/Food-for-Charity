package com.foodforcharity.app.infrastructure.repository;

import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.service.FoodService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long>, FoodService {
    // List<Food> findAllByDonorId(long donorId);
}
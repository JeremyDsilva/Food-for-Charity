package com.foodforcharity.api.repository;

import java.util.List;

import com.foodforcharity.api.entities.Food;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
    List<Food> findAllByDonorId(long donorId);
}
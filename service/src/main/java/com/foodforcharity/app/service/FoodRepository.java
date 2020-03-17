package com.foodforcharity.app.service;

import java.util.List;

import com.foodforcharity.app.domain.entity.Food;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
    List<Food> findAllByDonorId(long donorId);
}
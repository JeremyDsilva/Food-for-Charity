package com.foodforcharity.app.domain.service;

import java.util.List;

import com.foodforcharity.app.domain.entity.Food;

import org.springframework.stereotype.Component;

@Component
public interface FoodService extends Service<Food> {
    List<Food> findAllByDonorId(long donorId);

    void deleteById(Long id);

    void delete(Food entity);
}
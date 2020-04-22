package com.foodforcharity.app.domain.service;

import com.foodforcharity.app.domain.entity.Food;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FoodService extends Service<Food> {
    List<Food> findAllByDonorId(long donorId);

    void delete(Food food);
}
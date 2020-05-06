package com.foodforcharity.app.usecase.profile.selectpreferences;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Data
@NoArgsConstructor
public class SelectPreferencesCommand implements Command<Response<Void>> {
    long doneeId;
    Range<SpiceLevel>spiceRange;
    List<Allergen> allergens;
    Range<Integer> priceRange;
    List<Cuisine> cuisines;
    List<MealType> mealTypes;

    @Value
    public class Range<T> {
        T start;
        T stop;
    }
    
}

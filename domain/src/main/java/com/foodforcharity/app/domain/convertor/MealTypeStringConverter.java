package com.foodforcharity.app.domain.convertor;

import com.foodforcharity.app.domain.constant.MealType;

public class MealTypeStringConverter extends EnumStringConverter<MealType>  {

    public MealTypeStringConverter() {
        super(MealType.class);
    }

}
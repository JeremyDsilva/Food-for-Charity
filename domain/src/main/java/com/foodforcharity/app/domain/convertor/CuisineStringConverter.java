package com.foodforcharity.app.domain.convertor;

import com.foodforcharity.app.domain.constant.Cuisine;

public class CuisineStringConverter extends EnumStringConverter<Cuisine> {

    public CuisineStringConverter(){
        super(Cuisine.class);
    }

}
package com.foodforcharity.app.domain.convertor;

import com.foodforcharity.app.domain.constant.Allergen;

public class AllergenStringConverter extends EnumStringConverter<Allergen> {

    public AllergenStringConverter() {
        super(Allergen.class);
    }

}
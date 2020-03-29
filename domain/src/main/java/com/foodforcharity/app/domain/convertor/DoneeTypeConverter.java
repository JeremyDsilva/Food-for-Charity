package com.foodforcharity.app.domain.convertor;

import javax.persistence.Converter;

import com.foodforcharity.app.domain.constant.DoneeType;

@Converter
public class DoneeTypeConverter extends EnumStringConverter<DoneeType> {

    public DoneeTypeConverter() {
        super(DoneeType.class);
    }

}
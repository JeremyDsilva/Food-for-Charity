package com.foodforcharity.app.domain.convertor;

import javax.persistence.Converter;

import com.foodforcharity.app.domain.constant.DoneeStatus;

@Converter
public class DoneeStatusConverter extends EnumStringConverter<DoneeStatus> {

    public DoneeStatusConverter() {
        super(DoneeStatus.class);
    }

}
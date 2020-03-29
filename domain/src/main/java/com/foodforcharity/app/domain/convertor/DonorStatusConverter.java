package com.foodforcharity.app.domain.convertor;

import javax.persistence.Converter;

import com.foodforcharity.app.domain.constant.DonorStatus;

@Converter
public class DonorStatusConverter extends EnumStringConverter<DonorStatus> {

    public DonorStatusConverter() {
        super(DonorStatus.class);
    }

}
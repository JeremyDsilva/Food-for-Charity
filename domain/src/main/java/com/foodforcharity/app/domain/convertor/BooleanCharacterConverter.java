package com.foodforcharity.app.domain.convertor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanCharacterConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null)
            throw new NullPointerException();
        return attribute ? 'Y' : 'N';
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData == 'Y')
            return true;
        else if (dbData == 'N')
            return false;
        throw new IllegalArgumentException("Unexpected Character " + dbData);
    }


}
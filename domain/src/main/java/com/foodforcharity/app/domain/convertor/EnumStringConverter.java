package com.foodforcharity.app.domain.convertor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public abstract class EnumStringConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    Class<E> enumType;

    /**
     * @param enumType
     */
    public EnumStringConverter(Class<E> enumType) {
        this.enumType = enumType;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (attribute == null)
            throw new NullPointerException();
        return attribute.name();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if (dbData == null)
            throw new NullPointerException();

        return Enum.valueOf(enumType, dbData);
    }

}
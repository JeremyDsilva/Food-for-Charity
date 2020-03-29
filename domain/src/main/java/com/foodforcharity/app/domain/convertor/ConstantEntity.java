package com.foodforcharity.app.domain.convertor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class ConstantEntity<E extends Enum<E>> {

    @Transient
    private EnumStringConverter<E> converter;

    @Id
    protected String id;

    public ConstantEntity(EnumStringConverter<E> converter){
        this.converter = converter;
    }

    public E getConstant(){
		return converter.convertToEntityAttribute(id);
	}

	public void setConstant(E attribute){
		this.id = converter.convertToDatabaseColumn(attribute);
	}

}
package com.foodforcharity.app.domain.convertor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class ConstantEntity<E extends Enum<E>> {

    @Transient
    private EnumStringConverter<E> converter;

    @Transient
	List<E> enums;

    @Id
    protected int id;

    protected String name;

    public ConstantEntity(EnumStringConverter<E> converter, List<E> enums){
        this.converter = converter;
        this.enums = enums;
    }

    public E getConstant(){
		return converter.convertToEntityAttribute(name);
	}

	public void setConstant(E attribute){
        this.id = enums.indexOf(attribute);
        this.name = converter.convertToDatabaseColumn(attribute);
    }

    public static <E extends Enum<E>> List<E> getConstants(List<? extends ConstantEntity<E>> constantEntities){
        List<E> list = new ArrayList<E>(); 
        for (var entity : constantEntities) {
            list.add(entity.getConstant());
        }
        return list;
    }

}
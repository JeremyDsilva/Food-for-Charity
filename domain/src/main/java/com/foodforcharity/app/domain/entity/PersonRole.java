package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodforcharity.app.domain.convertor.ConstantEntity;
import com.foodforcharity.app.domain.convertor.PersonRoleStringConverter;

/**
 * The persistent class for the PERSON_ROLE database table.
 * 
 */
@Entity
@Table(name = "PERSON_ROLE")
public class PersonRole extends ConstantEntity<com.foodforcharity.app.domain.constant.PersonRole> implements Serializable {
	private static final long serialVersionUID = 1L;

	public PersonRole(){
		super(new PersonRoleStringConverter());
	}

	public PersonRole(com.foodforcharity.app.domain.constant.PersonRole personRole) {
		this();
		setConstant(personRole);
	}	

}


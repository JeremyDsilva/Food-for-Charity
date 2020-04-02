package com.foodforcharity.app.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The persistent class for the BROKER database table.
 * 
 */
@Entity
@DiscriminatorValue("Broker")
public class Broker extends Person {
	private static final long serialVersionUID = 1L;

	public Broker() {
	}

}
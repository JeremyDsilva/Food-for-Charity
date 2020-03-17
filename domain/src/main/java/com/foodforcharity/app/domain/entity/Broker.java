package com.foodforcharity.app.domain.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * The persistent class for the BROKER database table.
 * 
 */
@Entity
@PrimaryKeyJoinColumn
public class Broker extends Person {
	private static final long serialVersionUID = 1L;

	public Broker() {
	}

}
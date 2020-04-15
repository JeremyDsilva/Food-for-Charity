package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the DONEE_PRICE_RANGE database table.
 * 
 */
@Entity
@Table(name="DONEE_PRICE_RANGE")
public class DoneePriceRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Donee donee;

	@Column(name="END_PRICE")
	@NotNull
	private Integer endPrice;

	@Column(name="START_PRICE")
	@NotNull
	private Integer startPrice;

}
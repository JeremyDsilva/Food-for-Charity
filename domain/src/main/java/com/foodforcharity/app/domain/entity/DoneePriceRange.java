package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DONEE_PRICE_RANGE database table.
 * 
 */
@Entity
@Table(name="DONEE_PRICE_RANGE")
public class DoneePriceRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="END_PRICE")
	private BigDecimal endPrice;

	@Column(name="START_PRICE")
	private BigDecimal startPrice;

	//bi-directional many-to-one association to Donee
	@ManyToOne
	private Donee donee;

	public DoneePriceRange() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getEndPrice() {
		return this.endPrice;
	}

	public void setEndPrice(BigDecimal endPrice) {
		this.endPrice = endPrice;
	}

	public BigDecimal getStartPrice() {
		return this.startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

	public Donee getDonee() {
		return this.donee;
	}

	public void setDonee(Donee donee) {
		this.donee = donee;
	}

}
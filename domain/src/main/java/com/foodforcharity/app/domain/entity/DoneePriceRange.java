package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

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
	private Integer endPrice;

	@Column(name="START_PRICE")
	private Integer startPrice;

	//bi-directional many-to-one association to Donee
	@OneToOne
	private Donee donee;

	public DoneePriceRange() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getEndPrice() {
		return this.endPrice;
	}

	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
	}

	public Integer getStartPrice() {
		return this.startPrice;
	}

	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}

	public Donee getDonee() {
		return this.donee;
	}

	public void setDonee(Donee donee) {
		this.donee = donee;
	}

}
package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the SUB_REQUEST database table.
 * 
 */
@Entity
@Table(name = "SUB_REQUEST")
public class SubRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "PRICE_AT_PURCHASE")
	private Integer priceAtPurchase;

	private Integer quantity;

	// bi-directional many-to-one association to Request
	@ManyToOne
	private Request request;

	// bi-directional many-to-one association to Food
	@ManyToOne
	private Food food;

	public SubRequest() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPriceAtPurchase() {
		return this.priceAtPurchase;
	}

	public void setPriceAtPurchase(Integer priceAtPurchase) {
		this.priceAtPurchase = priceAtPurchase;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Request getRequest() {
		return this.request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
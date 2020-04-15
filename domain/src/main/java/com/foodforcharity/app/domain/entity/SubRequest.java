package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * The persistent class for the SUB_REQUEST database table.
 * 
 */
@Data
@Entity
@Table(name = "SUB_REQUEST")
public class SubRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "PRICE_AT_PURCHASE")
	@NotNull
	private Integer priceAtPurchase;

	@NotNull
	private Integer quantity;

	// bi-directional many-to-one association to Request
	@ManyToOne
	@NotNull
	private Request request;

	// bi-directional many-to-one association to Food
	@ManyToOne
	@NotNull
	private Food food;

}
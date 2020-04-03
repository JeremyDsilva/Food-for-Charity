package com.foodforcharity.app.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.constant.SpiceLevel;

/**
 * The persistent class for the DONEE_SPICE_RANGE database table.
 * 
 */
@Entity
@Table(name = "DONEE_SPICE_RANGE")
public class DoneeSpiceRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// bi-directional many-to-one association to Donee
	@OneToOne
	private Donee donee;

	// bi-directional many-to-one association to SpiceLevel
	@Enumerated(EnumType.STRING)
	@NotNull
	private SpiceLevel startLevel;
	
	// bi-directional many-to-one association to SpiceLevel
	@Enumerated(EnumType.STRING)
	@NotNull
	private SpiceLevel endLevel;

	public DoneeSpiceRange() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Donee getDonee() {
		return this.donee;
	}

	public void setDonee(Donee donee) {
		this.donee = donee;
	}

	public SpiceLevel getStartLevel() {
		return this.startLevel;
	}

	public void setStartLevel(SpiceLevel spiceLevel) {
		this.startLevel = spiceLevel;
	}

	public SpiceLevel getEndLevel() {
		return this.endLevel;
	}

	public void setEndLevel(SpiceLevel spiceLevel) {
		this.endLevel = spiceLevel;
	}

}
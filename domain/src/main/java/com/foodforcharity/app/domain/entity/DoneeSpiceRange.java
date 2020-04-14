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

import lombok.Data;

/**
 * The persistent class for the DONEE_SPICE_RANGE database table.
 * 
 */
@Data
@Entity
@Table(name = "DONEE_SPICE_RANGE")
public class DoneeSpiceRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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

}
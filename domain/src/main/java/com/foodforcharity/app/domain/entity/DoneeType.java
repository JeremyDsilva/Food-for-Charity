package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DONEE_TYPE database table.
 * 
 */
@Entity
@Table(name="DONEE_TYPE")
public class DoneeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to Donee
	@OneToMany(mappedBy="doneeType", fetch=FetchType.LAZY)
	private List<Donee> donees;

	public DoneeType() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Donee> getDonees() {
		return this.donees;
	}

	public void setDonees(List<Donee> donees) {
		this.donees = donees;
	}

	public Donee addDonee(Donee donee) {
		getDonees().add(donee);
		donee.setDoneeType(this);

		return donee;
	}

	public Donee removeDonee(Donee donee) {
		getDonees().remove(donee);
		donee.setDoneeType(null);

		return donee;
	}

}
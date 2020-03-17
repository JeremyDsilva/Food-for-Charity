package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DONEE_STATUS database table.
 * 
 */
@Entity
@Table(name="DONEE_STATUS")
public class DoneeStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to Donee
	@OneToMany(mappedBy="doneeStatus", fetch=FetchType.EAGER)
	private List<Donee> donees;

	//bi-directional many-to-one association to Authority
	@ManyToOne
	private Authority authority;

	public DoneeStatus() {
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
		donee.setDoneeStatus(this);

		return donee;
	}

	public Donee removeDonee(Donee donee) {
		getDonees().remove(donee);
		donee.setDoneeStatus(null);

		return donee;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
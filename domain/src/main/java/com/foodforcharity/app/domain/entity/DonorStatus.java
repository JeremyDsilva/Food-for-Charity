// package com.foodforcharity.app.domain.entity;

// import java.io.Serializable;
// import javax.persistence.*;
// import java.util.List;


// /**
//  * The persistent class for the DONOR_STATUS database table.
//  * 
//  */
// @Entity
// @Table(name="DONOR_STATUS")
// public class DonorStatus implements Serializable {
// 	private static final long serialVersionUID = 1L;

// 	@Id
// 	@Column(name = "id")
// 	private String name;

// 	//bi-directional many-to-one association to Donor
// 	@OneToMany(mappedBy="donorStatus", fetch=FetchType.EAGER)
// 	private List<Donor> donors;

// 	// //bi-directional many-to-one association to Authority
// 	// @ManyToOne
// 	// private Authority authority;

// 	public DonorStatus() {
// 	}

// 	// public long getId() {
// 	// 	return this.id;
// 	// }

// 	// public void setId(long id) {
// 	// 	this.id = id;
// 	// }

// 	public String getName() {
// 		return this.name;
// 	}

// 	public void setName(String name) {
// 		this.name = name;
// 	}

// 	public List<Donor> getDonors() {
// 		return this.donors;
// 	}

// 	public void setDonors(List<Donor> donors) {
// 		this.donors = donors;
// 	}

// 	public Donor addDonor(Donor donor) {
// 		getDonors().add(donor);
// 		donor.setDonorStatus(this);

// 		return donor;
// 	}

// 	public Donor removeDonor(Donor donor) {
// 		getDonors().remove(donor);
// 		donor.setDonorStatus(null);

// 		return donor;
// 	}

// 	// public Authority getAuthority() {
// 	// 	return this.authority;
// 	// }

// 	// public void setAuthority(Authority authority) {
// 	// 	this.authority = authority;
// 	// }

// }
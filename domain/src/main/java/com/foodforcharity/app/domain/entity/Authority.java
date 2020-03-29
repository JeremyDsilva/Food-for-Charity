// package com.foodforcharity.app.domain.entity;

// import java.io.Serializable;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// /**
//  * The persistent class for the AUTHORITY database table.
//  * 
//  */
// @Entity
// public class Authority implements Serializable {
// 	private static final long serialVersionUID = 1L;

// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private long id;

// 	private String authority;

// 	// // bi-directional many-to-one association to DoneeStatus
// 	// @OneToMany(mappedBy = "authority", fetch = FetchType.EAGER)
// 	// private List<DoneeStatus> doneeStatuses;

// 	// // bi-directional many-to-one association to DonorStatus
// 	// @OneToMany(mappedBy = "authority", fetch = FetchType.EAGER)
// 	// private List<DonorStatus> donorStatuses;

// 	public Authority() {
// 	}

// 	public long getId() {
// 		return this.id;
// 	}

// 	public void setId(long id) {
// 		this.id = id;
// 	}

// 	public String getAuthority() {
// 		return this.authority;
// 	}

// 	public void setAuthority(String authority) {
// 		this.authority = authority;
// 	}

// 	// public List<DoneeStatus> getDoneeStatuses() {
// 	// return this.doneeStatuses;
// 	// }

// 	// public void setDoneeStatuses(List<DoneeStatus> doneeStatuses) {
// 	// this.doneeStatuses = doneeStatuses;
// 	// }

// 	// public DoneeStatus addDoneeStatus(DoneeStatus doneeStatus) {
// 	// getDoneeStatuses().add(doneeStatus);
// 	// doneeStatus.setAuthority(this);

// 	// return doneeStatus;
// 	// }

// 	// public DoneeStatus removeDoneeStatus(DoneeStatus doneeStatus) {
// 	// getDoneeStatuses().remove(doneeStatus);
// 	// doneeStatus.setAuthority(null);

// 	// return doneeStatus;
// 	// }

// 	// public List<DonorStatus> getDonorStatuses() {
// 	// return this.donorStatuses;
// 	// }

// 	// public void setDonorStatuses(List<DonorStatus> donorStatuses) {
// 	// this.donorStatuses = donorStatuses;
// 	// }

// 	// public DonorStatus addDonorStatus(DonorStatus donorStatus) {
// 	// getDonorStatuses().add(donorStatus);
// 	// donorStatus.setAuthority(this);

// 	// return donorStatus;
// 	// }

// 	// public DonorStatus removeDonorStatus(DonorStatus donorStatus) {
// 	// getDonorStatuses().remove(donorStatus);
// 	// donorStatus.setAuthority(null);

// 	// return donorStatus;
// 	// }

// }
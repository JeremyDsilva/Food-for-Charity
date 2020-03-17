package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.foodforcharity.app.domain.convertor.BooleanCharacterConverter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the REQUEST database table.
 * 
 */
@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="DISCOUNT_APPLIED")
	private Integer discountApplied;

	@Column(name="FINAL_PRICE")
	private Integer finalPrice;

	@Column(name="IS_ACTIVE")
	@Convert(converter = BooleanCharacterConverter.class)
	private Boolean isActive;

	@Column(name="IS_RATED")
	@Convert(converter = BooleanCharacterConverter.class)
	private Boolean isRated;

	@Column(name="REQUEST_TIME")
	private Date requestTime;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="request", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Complaint> complaints;

	//bi-directional many-to-one association to Donor
	@ManyToOne
	private Donor donor;

	//bi-directional many-to-one association to Donee
	@ManyToOne
	private Donee donee;

	//bi-directional many-to-one association to SubRequest
	@OneToMany(mappedBy="request", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubRequest> subRequests;

	public Request() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getDiscountApplied() {
		return this.discountApplied;
	}

	public void setDiscountApplied(Integer discountApplied) {
		this.discountApplied = discountApplied;
	}

	public Integer getFinalPrice() {
		return this.finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	// public Boolean getIsActive() {
	// 	return this.isActive;
	// }

	// public Boolean setIsActive(Boolean isActive) {
	// 	this.isActive = isActive;
	// }

	// public Boolean getIsRated() {
	// 	return this.isRated;
	// }

	// public void setIsRated(Boolean isRated) {
	// 	this.isRated = isRated;
	// }

	public Date getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setRequest(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setRequest(null);

		return complaint;
	}

	public Donor getDonor() {
		return this.donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Donee getDonee() {
		return this.donee;
	}

	public void setDonee(Donee donee) {
		this.donee = donee;
	}

	public List<SubRequest> getSubRequests() {
		return this.subRequests;
	}

	public void setSubRequests(List<SubRequest> subRequests) {
		this.subRequests = subRequests;
	}

	public SubRequest addSubRequest(SubRequest subRequest) {
		getSubRequests().add(subRequest);
		subRequest.setRequest(this);

		return subRequest;
	}

	public SubRequest removeSubRequest(SubRequest subRequest) {
		getSubRequests().remove(subRequest);
		subRequest.setRequest(null);

		return subRequest;
	}

}
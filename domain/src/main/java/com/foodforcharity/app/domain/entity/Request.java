package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.foodforcharity.app.domain.convertor.BooleanCharacterConverter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


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
	@NotNull
	private Integer discountApplied;

	@Column(name="FINAL_PRICE")
	@NotNull
	private Integer finalPrice;

	@Column(name="IS_ACTIVE")
	@Convert(converter = BooleanCharacterConverter.class)
	@NotNull
	private Boolean isActive;

	@Column(name="IS_RATED")
	@Convert(converter = BooleanCharacterConverter.class)
	@NotNull
	private Boolean isRated;

	@Column(name="REQUEST_TIME")
	@NotNull
	private Date requestTime;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="request", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@NotNull
	private List<Complaint> complaints;

	//bi-directional many-to-one association to Donor
	@ManyToOne
	@NotNull
	private Donor donor;

	//bi-directional many-to-one association to Donee
	@ManyToOne
	@NotNull
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

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isRated
	 */
	public Boolean getIsRated() {
		return isRated;
	}

	/**
	 * @param isRated the isRated to set
	 */
	public void setIsRated(Boolean isRated) {
		this.isRated = isRated;
	}

}
package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.Data;

/**
 * The persistent class for the REQUEST database table.
 * 
 */
@Data
@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "DISCOUNT_APPLIED")
	@NotNull
	private Integer discountApplied;

	@Column(name = "FINAL_PRICE")
	@NotNull
	private Integer finalPrice;

	@Column(name = "IS_ACTIVE")
	@Convert(converter = BooleanCharacterConverter.class)
	@NotNull
	private Boolean isActive;

	@Column(name = "IS_RATED")
	@Convert(converter = BooleanCharacterConverter.class)
	@NotNull
	private Boolean isRated;

	@Column(name = "REQUEST_TIME")
	@NotNull
	private Date requestTime;

	// bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Complaint> complaints;

	// bi-directional many-to-one association to Donor
	@ManyToOne
	@NotNull
	private Donor donor;

	// bi-directional many-to-one association to Donee
	@ManyToOne
	@NotNull
	private Donee donee;

	// bi-directional many-to-one association to SubRequest
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubRequest> subRequests;

	public Complaint addComplaint(Complaint complaint) {
		if (getComplaints() == null)
			setComplaints(Arrays.asList(complaint));
		else
			getComplaints().add(complaint);
		complaint.setRequest(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setRequest(null);

		return complaint;
	}

	public SubRequest addSubRequest(SubRequest subRequest) {
		if (getSubRequests() == null)
			setSubRequests(Arrays.asList(subRequest));
		else
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
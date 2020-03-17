package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.foodforcharity.app.domain.convertor.BooleanCharacterConverter;

/**
 * The persistent class for the COMPLAINT database table.
 * 
 */
@Entity
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "COMPLAINT_TIME")
	private Date complaintTime;

	@Column(name = "DESCRIPTION_TEXT")
	private String descriptionText;

	@Column(name = "FROM_DONEE")
	@Convert(converter = BooleanCharacterConverter.class)
	private Boolean fromDonee;

	@Column(name = "IS_ACTIVE")
	@Convert(converter = BooleanCharacterConverter.class)
	private Boolean isActive;

	// bi-directional many-to-one association to Request
	@ManyToOne
	private Request request;

	public Complaint() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getComplaintTime() {
		return this.complaintTime;
	}

	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}

	public String getDescriptionText() {
		return this.descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	// public String getFromDonee() {
	// return this.fromDonee;
	// }

	// public void setFromDonee(String fromDonee) {
	// this.fromDonee = fromDonee;
	// }

	// public String getIsActive() {
	// return this.isActive;
	// }

	// public void setIsActive(String isActive) {
	// this.isActive = isActive;
	// }

	public Request getRequest() {
		return this.request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
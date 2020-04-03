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
import javax.validation.constraints.NotNull;

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
	@NotNull
	private Date complaintTime;

	@Column(name = "DESCRIPTION_TEXT")
	@NotNull
	private String descriptionText;

	@Column(name = "FROM_DONEE")
	@NotNull
	@Convert(converter = BooleanCharacterConverter.class)
	private Boolean fromDonee;

	@Column(name = "IS_ACTIVE")
	@Convert(converter = BooleanCharacterConverter.class)
	@NotNull
	private Boolean isActive;

	// bi-directional many-to-one association to Request
	@ManyToOne
	@NotNull
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

	public Request getRequest() {
		return this.request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * @return the fromDonee
	 */
	public Boolean getFromDonee() {
		return fromDonee;
	}

	/**
	 * @param fromDonee the fromDonee to set
	 */
	public void setFromDonee(Boolean fromDonee) {
		this.fromDonee = fromDonee;
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

}
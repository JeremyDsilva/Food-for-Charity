package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the ERROR_LOG database table.
 * 
 */
@Entity
@Table(name = "ERROR_LOG")
public class ErrorLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "DESCRIPTION_TEXT")
	@NotNull
	private String descriptionText;

	@Column(name = "ERROR_TIME")
	@NotNull
	private Date errorTime;

	public ErrorLog() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescriptionText() {
		return this.descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public Date getErrorTime() {
		return this.errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

}
package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * The persistent class for the PERSON database table.
 * 
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PersonRole")
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private long id;

	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	private String password;

	public String getRole(){
		return getClass().getSimpleName();
	}

	public Optional<String> getStatus(){
		return Optional.empty();
	}

}
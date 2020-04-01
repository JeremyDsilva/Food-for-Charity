package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.foodforcharity.app.domain.security.PersonStatus;

/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD_HASH")
	private String passwordHash;

	@Column(name = "PASSWORD_SALT")
	private String passwordSalt;

	// bi-directional many-to-one association to MapPersonRole
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "MapPersonRole", joinColumns = {
			@JoinColumn(name = "id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "RoleId", referencedColumnName = "id") })
	// @Convert(converter = PersonRoleConverter.class)
	private PersonRole personRole;

	public Person() {
	}

	public Person(com.foodforcharity.app.domain.constant.PersonRole personRole){
		this.personRole = new PersonRole(personRole); 
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public com.foodforcharity.app.domain.constant.PersonRole getPersonRole() {
		return personRole.getConstant();
	}

	protected void setPersonRole(com.foodforcharity.app.domain.constant.PersonRole personRole) {
		this.personRole.setConstant(personRole);
	}

	public Optional<PersonStatus> getPersonStatus() {
		return Optional.empty();
	}

}
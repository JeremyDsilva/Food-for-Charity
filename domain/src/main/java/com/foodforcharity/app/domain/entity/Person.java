package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MapPersonRole", joinColumns = {
			@JoinColumn(name = "id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "RoleId", referencedColumnName = "id") })
	private List<PersonRole> personRoles;

	public Person() {
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

	// public List<MapPersonRole> getMapPersonRoles() {
	// 	return this.mapPersonRoles;
	// }

	// public void setMapPersonRoles(List<MapPersonRole> mapPersonRoles) {
	// 	this.mapPersonRoles = mapPersonRoles;
	// }

	// public MapPersonRole addMapPersonRole(MapPersonRole mapPersonRole) {
	// 	getMapPersonRoles().add(mapPersonRole);
	// 	mapPersonRole.setPerson(this);

	// 	return mapPersonRole;
	// }

	// public MapPersonRole removeMapPersonRole(MapPersonRole mapPersonRole) {
	// 	getMapPersonRoles().remove(mapPersonRole);
	// 	mapPersonRole.setPerson(null);

	// 	return mapPersonRole;
	// }

}
package com.foodforcharity.app.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * The persistent class for the PERSON_ROLE database table.
 * 
 */
@Entity
@Table(name = "PERSON_ROLE")
public class PersonRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	// bi-directional many-to-one association to MapPersonRole
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MapPersonRole", joinColumns = {
			@JoinColumn(name = "RoleId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "Id", referencedColumnName = "Id") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Person> persons;

	public PersonRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public List<MapPersonRole> getMapPersonRoles() {
	// return this.mapPersonRoles;
	// }

	// public void setMapPersonRoles(List<MapPersonRole> mapPersonRoles) {
	// this.mapPersonRoles = mapPersonRoles;
	// }

	// public MapPersonRole addMapPersonRole(MapPersonRole mapPersonRole) {
	// getMapPersonRoles().add(mapPersonRole);
	// mapPersonRole.setPersonRole(this);

	// return mapPersonRole;
	// }

	// public MapPersonRole removeMapPersonRole(MapPersonRole mapPersonRole) {
	// getMapPersonRoles().remove(mapPersonRole);
	// mapPersonRole.setPersonRole(null);

	// return mapPersonRole;
	// }

}
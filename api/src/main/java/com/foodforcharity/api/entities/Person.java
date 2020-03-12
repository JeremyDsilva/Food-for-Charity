package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Person", schema = "b00074902")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private long id;

  @Column(name = "Username")
  String username;

  @Column(name = "PasswordHash")
  String passwordHash;

  @Column(name = "PasswordSalt")
  String passwordSalt;

  @Column(name = "LastLoginTime")
  Date lastLoginTime;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "MapPersonRole", joinColumns = {
      @JoinColumn(name = "PersonId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "RoleId", referencedColumnName = "id") })
  PersonRole roles;

}

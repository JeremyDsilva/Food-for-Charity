package com.foodforcharity.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Person", schema = "b00074902")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private long id;

  @Column(name = "Username")
  String userName;

  @Column(name = "PasswordHash")
  String passwordHash;

  @Column(name = "PasswordSalt")
  String passwordSalt;

  @Column(name = "LastLoginTime")
  Date lastLoginTime;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MapPersonRole", joinColumns = {
      @JoinColumn(name = "PersonId", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "RoleId", referencedColumnName = "id") })
  List<PersonRole> roles;

  public Person(String userName, String passwordHash, String passwordSalt, Date lastLoginTime, List<PersonRole> roles) {
    this.userName = userName;
    this.passwordHash = passwordHash;
    this.passwordSalt = passwordSalt;
    this.lastLoginTime = lastLoginTime;
    this.roles = roles;
  }

  public Person(){};

}

package com.foodforcharity.app.domain;
import java.util.Date;

import com.foodforcharity.common.Authority.PersonRole;


public abstract class Person {
 
  private long PersonId;

  String username;

  String passwordHash;

  String passwordSalt;

  Date lastLoginTime;

  PersonRole roles;

}

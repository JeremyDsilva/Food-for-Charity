package com.foodforcharity.app.domain;

import java.util.Date;
import java.util.List;

import com.foodforcharity.common.Enum.PersonRole;

public class Person {

  long id;

  String username;

  String passwordHash;

  String passwordSalt;

  Date lastLoginTime;

  List<PersonRole> roles;

}

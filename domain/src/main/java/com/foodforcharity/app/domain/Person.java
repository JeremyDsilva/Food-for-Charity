package com.foodforcharity.app.domain;

import java.util.Date;

import com.foodforcharity.common.Authority.PersonRole;

import org.springframework.security.core.userdetails.UserDetails;

public abstract class Person implements UserDetails {

  long id;

  String username;

  String passwordHash;

  String passwordSalt;

  Date lastLoginTime;

  PersonRole personRole;

  @Override
  public String getPassword() {
    return passwordHash;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}

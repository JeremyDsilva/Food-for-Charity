package com.foodforcharity.app.domain;

import java.util.Arrays;
import java.util.Collection;

import com.foodforcharity.common.Authority;
import com.foodforcharity.common.Authority.BrokerStatus;
import com.foodforcharity.common.Authority.PersonRole;

import org.springframework.security.core.GrantedAuthority;

public class Broker extends Person {
  
  long id;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return Arrays.asList(new Authority(PersonRole.Broker, BrokerStatus.Active ));
  }  

  
}

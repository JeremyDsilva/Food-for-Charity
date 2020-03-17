package com.foodforcharity.app.domain.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.foodforcharity.app.domain.entity.Authority;
import com.foodforcharity.app.domain.entity.Person;

public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Person person;
    private List<Authority> authGroups;

    public UserPrincipal(Person person, List<Authority> authGroups){
        super();
        this.person = person;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null==authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        // authGroups.forEach(group->{
        //    grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()));
        // });
        return grantedAuthorities;

    }

    @Override
    public String getPassword() {
        return this.person.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
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

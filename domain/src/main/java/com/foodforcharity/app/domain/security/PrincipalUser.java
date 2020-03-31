package com.foodforcharity.app.domain.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.foodforcharity.app.domain.entity.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class PrincipalUser extends User {

    final long personId;

    public PrincipalUser(Person person) {
        super(person.getUsername(), person.getPasswordHash(), getAuthorities(person));
        personId = person.getId();
    }

    static Collection<? extends GrantedAuthority> getAuthorities(Person person) {

        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(person.getPersonRole().name()));

        person.getPersonStatus().ifPresent(status -> {
            authorities.add(new SimpleGrantedAuthority(status.name()));
        });

        return authorities;
    }

}
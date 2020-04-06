package com.foodforcharity.app.domain.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.foodforcharity.app.domain.entity.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PersonDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    final long personId;
    final String username;
    String password;
    final Collection<? extends GrantedAuthority> authorities;

    public PersonDetails(Person person) {
        this.personId = person.getId();
        this.username = person.getUsername();
        this.password = person.getPassword();

        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(person.getRole()));
        person.getStatus().ifPresent(status -> {
            authorities.add(new SimpleGrantedAuthority(status));
        });

        this.authorities = authorities;
    }

    public PersonDetails(long personId, String username, Collection<? extends GrantedAuthority> authorities){
        this.personId = personId;
        this.username = username;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
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

    /**
     * @return the personId
     */
    public long getPersonId() {
        return personId;
    }    

}
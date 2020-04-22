package com.foodforcharity.app.domain.security;

import com.foodforcharity.app.domain.entity.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PersonDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    final long personId;
    final String username;
    final String role;
    final String status;
    String password;

    public PersonDetails(Person person) {
        this.personId = person.getId();
        this.username = person.getUsername();
        this.password = person.getPassword();
        this.role = person.getRole();
        this.status = person.getStatus().orElse(role);
    }

    public PersonDetails(long personId, String username, String role, String status) {
        this.personId = personId;
        this.username = username;
        this.role = role;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(role));

        if (role != status) {
            authorities.add(new SimpleGrantedAuthority(status));
        }

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

    public String getRole() {
        return role;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

}
package com.foodforcharity.security.app.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
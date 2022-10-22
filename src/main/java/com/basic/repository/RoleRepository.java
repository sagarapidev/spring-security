package com.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.domain.Role;

/**
 * Spring Data JPA repository for the {@link Role} entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}

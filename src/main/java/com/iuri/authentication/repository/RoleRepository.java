package com.iuri.authentication.repository;

import com.iuri.authentication.enuns.RoleName;
import com.iuri.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}

package com.iuri.authentication.repository;

import com.iuri.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}

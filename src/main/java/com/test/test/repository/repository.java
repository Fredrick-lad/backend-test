package com.test.test.repository;
import com.test.test.entity.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface repository extends JpaRepository<user, Long> {
    Optional<user> findByUsername(String username);
    // Spring automatically provides methods like save(), findAll(), findById(), etc.
}


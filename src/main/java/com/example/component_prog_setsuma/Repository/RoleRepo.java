package com.example.component_prog_setsuma.Repository;

import java.util.Optional;

import com.example.component_prog_setsuma.Entity.ERole;
import com.example.component_prog_setsuma.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
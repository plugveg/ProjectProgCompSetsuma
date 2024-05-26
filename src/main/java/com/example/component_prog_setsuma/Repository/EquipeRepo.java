package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipeRepo extends JpaRepository<Equipe, Long> {

    @Query(value = "SELECT * FROM Equipe WHERE nom_equipe = ?1", nativeQuery = true)
    List<Equipe> getEquipeByName(String nomEquipe);
}

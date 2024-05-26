package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailEquipeRepo extends JpaRepository<DetailEquipe, Long> {

    @Query(value = "SELECT * FROM detail_equipe WHERE salle = ?1", nativeQuery = true)
    DetailEquipe getDetailEquipeBySalle(Integer salle);
}

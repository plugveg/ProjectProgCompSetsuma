package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartementRepo extends JpaRepository<Departement, Long> {

    @Query(value = "SELECT * FROM Departement WHERE nom_depart = ?1", nativeQuery = true)
    Departement getDepartementByName(String nomDepartement);
}

package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Entity.Equipe;
import com.example.component_prog_setsuma.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

    @Query(value = "SELECT * FROM Etudiant WHERE nom_etudiant = ?1", nativeQuery = true)
    Etudiant getEtudiantByName(String nomEtudiant);

    @Query(value = "SELECT * FROM Etudiant WHERE prenom_etudiant = ?1", nativeQuery = true)
    Etudiant getEtudiantByPrenom(String prenomEtudiant);

    @Query(value = "SELECT e.* FROM equipe e " +
            "JOIN etudiant_equipe ee ON e.id_equipe = ee.equipe_id_equipe " +
            "WHERE ee.etudiants_id_etudiant = :idEtudiant", nativeQuery = true)
    List<Object> findEquipesByEtudiantId(@Param("idEtudiant") Long idEtudiant);
}

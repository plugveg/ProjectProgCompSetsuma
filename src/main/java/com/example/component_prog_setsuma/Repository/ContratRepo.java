package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Contrat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratRepo extends JpaRepository<Contrat, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE contrat SET archive = b'0', etudiant_id_etudiant = :idEtudiant WHERE id_contrat = :idContrat", nativeQuery = true)
    void assignContratToEtudiant(@Param("idContrat") Long idContrat, @Param("idEtudiant") Long idEtudiant);

    @Query("SELECT c FROM Contrat c WHERE c.etudiant.id = :idEtudiant")
    List<Object> findContratsByEtudiantId(@Param("idEtudiant") Long idEtudiant);
}

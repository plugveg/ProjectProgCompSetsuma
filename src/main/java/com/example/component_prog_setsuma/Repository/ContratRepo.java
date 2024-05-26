package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContratRepo extends JpaRepository<Contrat, Long> {

    @Query(value = "UPDATE Contrat SET etudiant_id_etudiant = :idEtudiant WHERE id_contrat = :idContrat", nativeQuery = true)
    void assignContratToEtudiant(@Param("idContrat") Long idContrat, @Param("idEtudiant") Long idEtudiant);

}

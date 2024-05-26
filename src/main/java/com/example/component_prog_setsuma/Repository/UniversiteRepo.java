package com.example.component_prog_setsuma.Repository;

import com.example.component_prog_setsuma.Entity.Departement;
import com.example.component_prog_setsuma.Entity.Universite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniversiteRepo extends JpaRepository<Universite, Long> {

    @Query(value = "SELECT * FROM Universite WHERE nom_univ = ?1", nativeQuery = true)
    Universite getUniversiteByName(String nomUniversite);

    @Query(value = "SELECT d.* FROM departement d " +
            "JOIN universite_departements ud ON d.id_depart = ud.departements_id_depart " +
            "JOIN universite u ON ud.universite_id_univ = u.id_univ " +
            "WHERE u.id_univ = :idUniv", nativeQuery = true)
    List<Object> findDepartementsByUniversiteId(@Param("idUniv") Integer idUniv);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO universite_departements (universite_id_univ, departements_id_depart) VALUES (:idUniv, :idDepart)", nativeQuery = true)
    void assignDepartementToUniversite(@Param("idUniv") Long idUniv, @Param("idDepart") Long idDepart);
}

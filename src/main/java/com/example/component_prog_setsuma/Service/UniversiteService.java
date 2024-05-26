package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.Departement;
import com.example.component_prog_setsuma.Entity.Universite;
import com.example.component_prog_setsuma.Repository.UniversiteRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    @Autowired
    private UniversiteRepo universiteRepo;

    public List<Object> getDepartementsByUniversiteId(Integer idUniv) {
        return universiteRepo.findDepartementsByUniversiteId(idUniv);
    }

    public void assignDepartementToUniversite(Long idUniv, Long idDepart) {
        universiteRepo.assignDepartementToUniversite(idUniv, idDepart);
    }

    public Universite addUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }

    public Universite modifyUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }

    public void deleteUniversite(Universite universite) {
        universiteRepo.delete(universite);
    }

    public Optional<Universite> findUniversite(Long id) {
        return universiteRepo.findById(id);
    }

    public List<Universite> listUniversite() {
        return universiteRepo.findAll();
    }
}

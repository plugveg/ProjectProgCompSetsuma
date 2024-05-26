package com.example.component_prog_setsuma.Service;


import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Entity.Equipe;
import com.example.component_prog_setsuma.Entity.Etudiant;
import com.example.component_prog_setsuma.Repository.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepo etudiantRepo;

    public List<Contrat> getContratByEtudiant(Long idEtudiant) {
        return etudiantRepo.findContratsByEtudiantId(idEtudiant);
    }

    public List<Object> getEquipesByEtudiantId(Long idEtudiant) {
        return etudiantRepo.findEquipesByEtudiantId(idEtudiant);
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    public void deleteEtudiant(Etudiant etudiant) {
        etudiantRepo.delete(etudiant);
    }

    public Optional<Etudiant> findEtudiant(Long id) {
        return etudiantRepo.findById(id);
    }

    public List<Etudiant> listEtudiant() {
        return etudiantRepo.findAll();
    }
}

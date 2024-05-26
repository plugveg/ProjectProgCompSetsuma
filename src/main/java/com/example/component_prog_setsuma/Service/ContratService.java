package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Repository.ContratRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    @Autowired
    private ContratRepo contratRepo;

    @Transactional
    public void assignContratToEtudiant(Long contratId, Long etudiantId) {
        contratRepo.assignContratToEtudiant(contratId, etudiantId);
    }

    public Contrat addContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }

    public Contrat modifyContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }

    public void deleteContrat(Contrat contrat) {
        contratRepo.delete(contrat);
    }

    public Optional<Contrat> findContrat(Long id) {
        return contratRepo.findById(id);
    }

    public List<Contrat> listContrat() {
        return contratRepo.findAll();
    }
}

package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Repository.ContratRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    @Autowired
    private ContratRepo contratRepo;

    public void assignContratToEtudiant(Long contratId, Long etudiantId) {
        contratRepo.assignContratToEtudiant(contratId, etudiantId);
    }

    public List<Object> getContratsByEtudiantId(Long idEtudiant) {
        return contratRepo.findContratsByEtudiantId(idEtudiant);
    }

    @Transactional
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contrats = contratRepo.findAll();
        for (Contrat contrat : contrats) {
            Date dateFinContrat = contrat.getDateFinContrat();
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 15);
            Date dateIn15Days = c.getTime();

            if (dateFinContrat.before(dateIn15Days)) {
                if (contrat.getEtudiant() != null){
                    System.out.println("Le contrat n° " + contrat.getIdContrat() + " appartient à l'étudiant: " + contrat.getEtudiant().getNomE() + " " + contrat.getEtudiant().getPrenomE());
                } else {
                    System.out.println("Le contrat n° " + contrat.getIdContrat() + " n'appartient à aucun étudiant !");
                }
                System.out.println("Le contrat à une date de fin : " + dateFinContrat);
                System.out.println("Le contrat à une spécialité : " + contrat.getSpecialite() + "\n");

                if (dateFinContrat.before(new Date())) {
                    contrat.setArchive(true);
                    contratRepo.save(contrat);
                    System.out.println("Contrat n° " + contrat.getIdContrat() + " est maintenant archivé ! \n\n");
                }
            }
        }
        // Si on fait des returns dans une méthode transactionnelle, il faut que ce soit des void car sinon cette dernière ne parcourra tous les contrats
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

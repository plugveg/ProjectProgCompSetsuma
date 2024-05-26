package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @PostMapping("/{contratId}/etudiants/{etudiantId}")
    public ResponseEntity<Void> assignContratToEtudiant(@PathVariable Long contratId, @PathVariable Long etudiantId) {
        try {
            contratService.assignContratToEtudiant(contratId, etudiantId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add-contrat")
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        Contrat savedContrat = contratService.addContrat(contrat);
        return new ResponseEntity<>(savedContrat, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-contrat")
    public ResponseEntity<Contrat> modifyContrat(@RequestBody Contrat contrat) {
        Contrat modifiedContrat = contratService.modifyContrat(contrat);
        return new ResponseEntity<>(modifiedContrat, HttpStatus.OK);
    }

    @DeleteMapping("/delete-contrat")
    public ResponseEntity<Contrat> deleteContrat(@RequestParam(name = "idContrat") Long idContrat) {
        Optional<Contrat> Contrat = contratService.findContrat(idContrat);
        contratService.deleteContrat(Contrat.get());
        return new ResponseEntity<>(Contrat.get(), HttpStatus.OK);
    }

    @GetMapping("/contrat")
    public ResponseEntity<Contrat> findContrat(@RequestParam(name = "idContrat") Long idContrat) {
        Optional<Contrat> contrat = contratService.findContrat(idContrat);
        if (contrat.isPresent()) {
            return new ResponseEntity<>(contrat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/contrats")
    public List<Contrat> listContrat() {
        return contratService.listContrat();
    }
}

package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.Contrat;
import com.example.component_prog_setsuma.Entity.Equipe;
import com.example.component_prog_setsuma.Entity.Etudiant;
import com.example.component_prog_setsuma.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/{idEtudiant}/contrats")
    public ResponseEntity<List<Contrat>> getContratByEtudiant(@PathVariable Long idEtudiant) {
        List<Contrat> contrats = etudiantService.getContratByEtudiant(idEtudiant);
        if (contrats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("/{idEtudiant}/equipes")
    public ResponseEntity<List<Object>> getEquipesByEtudiantId(@PathVariable Long idEtudiant) {
        List<Object> equipes = etudiantService.getEquipesByEtudiantId(idEtudiant);
        if (equipes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    @PostMapping("/add-etudiant")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-etudiant")
    public ResponseEntity<Etudiant> modifyEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant modifiedEtudiant = etudiantService.modifyEtudiant(etudiant);
        return new ResponseEntity<>(modifiedEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete-etudiant")
    public ResponseEntity<Etudiant> deleteEtudiant(@RequestParam(name = "idEtudiant") Long idEtudiant) {
        Optional<Etudiant> etudiant = etudiantService.findEtudiant(idEtudiant);
        etudiantService.deleteEtudiant(etudiant.get());
        return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
    }

    @GetMapping("/etudiant")
    public ResponseEntity<Etudiant> findEtudiant(@RequestParam(name = "idEtudiant") Long idEtudiant) {
        Optional<Etudiant> etudiant = etudiantService.findEtudiant(idEtudiant);
        if (etudiant.isPresent()) {
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiants")
    public List<Etudiant> listEtudiant() {
        return etudiantService.listEtudiant();
    }
}

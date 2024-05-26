package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.Departement;
import com.example.component_prog_setsuma.Entity.Universite;
import com.example.component_prog_setsuma.Service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @GetMapping("/{idUniv}/departements")
    public ResponseEntity<List<Object>> getDepartementsByUniversiteId(@PathVariable Integer idUniv) {
        List<Object> departements = universiteService.getDepartementsByUniversiteId(idUniv);
        if (departements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

    @PostMapping("/{idUniv}/departements/{idDepart}")
    public ResponseEntity<Void> assignDepartementToUniversite(@PathVariable Long idUniv, @PathVariable Long idDepart) {
        try {
            universiteService.assignDepartementToUniversite(idUniv, idDepart);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add-universite")
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite) {
        Universite savedUniversite = universiteService.addUniversite(universite);
        return new ResponseEntity<>(savedUniversite, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-universite")
    public ResponseEntity<Universite> modifyUniversite(@RequestBody Universite universite) {
        Universite modifiedUniversite = universiteService.modifyUniversite(universite);
        return new ResponseEntity<>(modifiedUniversite, HttpStatus.OK);
    }

    @DeleteMapping("/delete-universite")
    public ResponseEntity<Universite> deleteUniversite(@RequestParam(name = "idUniversite") Long idUniversite) {
        Optional<Universite> Universite = universiteService.findUniversite(idUniversite);
        universiteService.deleteUniversite(Universite.get());
        return new ResponseEntity<>(Universite.get(), HttpStatus.OK);
    }

    @GetMapping("/universite")
    public ResponseEntity<Universite> uindUniversite(@RequestParam(name = "idUniversite") Long idUniversite) {
        Optional<Universite> universite = universiteService.findUniversite(idUniversite);
        if (universite.isPresent()) {
            return new ResponseEntity<>(universite.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/universites")
    public List<Universite> listUniversite() {
        return universiteService.listUniversite();
    }
}

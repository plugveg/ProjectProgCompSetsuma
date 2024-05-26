package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.Departement;
import com.example.component_prog_setsuma.Service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/departements")
public class DepartementController {
    
    @Autowired
    private DepartementService departementService;

    @PostMapping("/add-departement")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement) {
        Departement savedDepartement = departementService.addDepartement(departement);
        return new ResponseEntity<>(savedDepartement, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-departement")
    public ResponseEntity<Departement> modifyDepartement(@RequestBody Departement departement) {
        Departement modifiedDepartement = departementService.modifyDepartement(departement);
        return new ResponseEntity<>(modifiedDepartement, HttpStatus.OK);
    }

    @DeleteMapping("/delete-departement")
    public ResponseEntity<Departement> deleteDepartement(@RequestParam(name = "idDepartement") Long idDepartement) {
        Optional<Departement> Departement = departementService.findDepartement(idDepartement);
        departementService.deleteDepartement(Departement.get());
        return new ResponseEntity<>(Departement.get(), HttpStatus.OK);
    }

    @GetMapping("/departement")
    public ResponseEntity<Departement> findDepartement(@RequestParam(name = "idDepartement") Long idDepartement) {
        Optional<Departement> departement = departementService.findDepartement(idDepartement);
        if (departement.isPresent()) {
            return new ResponseEntity<>(departement.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/departements")
    public List<Departement> listDepartement() {
        return departementService.listDepartement();
    }
}

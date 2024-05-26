package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.Equipe;
import com.example.component_prog_setsuma.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @PostMapping("/add-equipe")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe savedEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(savedEquipe, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-equipe")
    public ResponseEntity<Equipe> modifyEquipe(@RequestBody Equipe equipe) {
        Equipe modifiedEquipe = equipeService.modifyEquipe(equipe);
        return new ResponseEntity<>(modifiedEquipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete-equipe")
    public ResponseEntity<Equipe> deleteEquipe(@RequestParam(name = "idEquipe") Long idEquipe) {
        Optional<Equipe> equipe = equipeService.findEquipe(idEquipe);
        equipeService.deleteEquipe(equipe.get());
        return new ResponseEntity<>(equipe.get(), HttpStatus.OK);
    }

    @GetMapping("/equipe")
    public ResponseEntity<Equipe> findEquipe(@RequestParam(name = "idEquipe") Long idEquipe) {
        Optional<Equipe> equipe = equipeService.findEquipe(idEquipe);
        if (equipe.isPresent()) {
            return new ResponseEntity<>(equipe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/equipes")
    public List<Equipe> listEquipe() {
        return equipeService.listEquipe();
    }
}

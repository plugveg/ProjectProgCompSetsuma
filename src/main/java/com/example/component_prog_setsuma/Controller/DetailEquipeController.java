package com.example.component_prog_setsuma.Controller;

import com.example.component_prog_setsuma.Entity.DetailEquipe;
import com.example.component_prog_setsuma.Service.DetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setsuma/detail-equipes")
public class DetailEquipeController {
    
    @Autowired
    private DetailEquipeService detailEquipeService;

    @PostMapping("/add-detail-equipe")
    public ResponseEntity<DetailEquipe> addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        DetailEquipe savedDetailEquipe = detailEquipeService.addDetailEquipe(detailEquipe);
        return new ResponseEntity<>(savedDetailEquipe, HttpStatus.CREATED);
    }

    @PatchMapping("/modify-detail-equipe")
    public ResponseEntity<DetailEquipe> modifyDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        DetailEquipe modifiedDetailEquipe = detailEquipeService.modifyDetailEquipe(detailEquipe);
        return new ResponseEntity<>(modifiedDetailEquipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete-detail-equipe")
    public ResponseEntity<DetailEquipe> deleteDetailEquipe(@RequestParam(name = "idDetailEquipe") Long idDetailEquipe) {
        Optional<DetailEquipe> DetailEquipe = detailEquipeService.findDetailEquipe(idDetailEquipe);
        detailEquipeService.deleteDetailEquipe(DetailEquipe.get());
        return new ResponseEntity<>(DetailEquipe.get(), HttpStatus.OK);
    }

    @GetMapping("/detail-equipe")
    public ResponseEntity<DetailEquipe> findDetailEquipe(@RequestParam(name = "idDetailEquipe") Long idDetailEquipe) {
        Optional<DetailEquipe> detailEquipe = detailEquipeService.findDetailEquipe(idDetailEquipe);
        if (detailEquipe.isPresent()) {
            return new ResponseEntity<>(detailEquipe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/detail-equipes")
    public List<DetailEquipe> listDetailEquipe() {
        return detailEquipeService.listDetailEquipe();
    }
}

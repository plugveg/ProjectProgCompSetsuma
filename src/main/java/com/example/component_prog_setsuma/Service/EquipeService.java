package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.Equipe;
import com.example.component_prog_setsuma.Repository.EquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepo equipeRepo;

    public Equipe addEquipe(Equipe equipe) {
        return equipeRepo.save(equipe);
    }

    public Equipe modifyEquipe(Equipe equipe) {
        return equipeRepo.save(equipe);
    }

    public void deleteEquipe(Equipe equipe) {
        equipeRepo.delete(equipe);
    }

    public Optional<Equipe> findEquipe(Long id) {
        return equipeRepo.findById(id);
    }

    public List<Equipe> listEquipe() {
        return equipeRepo.findAll();
    }
}

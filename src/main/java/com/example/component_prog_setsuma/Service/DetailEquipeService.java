package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.DetailEquipe;
import com.example.component_prog_setsuma.Repository.DetailEquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailEquipeService {
    
    @Autowired
    private DetailEquipeRepo detailEquipeRepo;

    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepo.save(detailEquipe);
    }

    public DetailEquipe modifyDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepo.save(detailEquipe);
    }

    public void deleteDetailEquipe(DetailEquipe detailEquipe) {
        detailEquipeRepo.delete(detailEquipe);
    }

    public Optional<DetailEquipe> findDetailEquipe(Long id) {
        return detailEquipeRepo.findById(id);
    }

    public List<DetailEquipe> listDetailEquipe() {
        return detailEquipeRepo.findAll();
    }
}

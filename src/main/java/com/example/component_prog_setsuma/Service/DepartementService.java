package com.example.component_prog_setsuma.Service;

import com.example.component_prog_setsuma.Entity.Departement;
import com.example.component_prog_setsuma.Repository.DepartementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepo departementRepo;

    public Departement addDepartement(Departement departement) {
        return departementRepo.save(departement);
    }

    public Departement modifyDepartement(Departement departement) {
        return departementRepo.save(departement);
    }

    public void deleteDepartement(Departement departement) {
        departementRepo.delete(departement);
    }

    public Optional<Departement> findDepartement(Long id) {
        return departementRepo.findById(id);
    }

    public List<Departement> listDepartement() {
        return departementRepo.findAll();
    }
}

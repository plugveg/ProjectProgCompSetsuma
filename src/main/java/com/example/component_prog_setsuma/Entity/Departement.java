package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Departement")
@Data
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;

    @Column(name = "nom_depart", nullable = false)
    private String nomDepart;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}

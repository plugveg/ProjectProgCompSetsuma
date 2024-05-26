package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Equipe")
@Data
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    @Column(name = "nom_equipe", nullable = false)
    private String nomEquipe;

    @Column(name = "niveau", nullable = false)
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToOne
    private DetailEquipe detailEquipe;
}

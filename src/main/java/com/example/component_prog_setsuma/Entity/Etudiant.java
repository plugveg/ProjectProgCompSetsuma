package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Etudiant")
@Data
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    @Column(name = "nom_etudiant", nullable = false)
    private String nomE;

    @Column(name = "prenom_etudiant", nullable = false)
    private String prenomE;

    @Column(name = "option_etudiant", nullable = false)
    @Enumerated(EnumType.STRING)
    private Option option;

    @ManyToOne
    private Departement departement;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Equipe> equipe;
}

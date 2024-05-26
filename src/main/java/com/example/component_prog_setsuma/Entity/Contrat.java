package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Contrat")
@Data
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(name = "date_debut_contrat", nullable = false)
    private Date dateDebutContrat;

    @Column(name = "date_fin_contrat", nullable = false)
    private Date dateFinContrat;

    @Column(name = "specialite", nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @Column(name = "archive", nullable = false)
    private Boolean archive;

    @Column(name = "montant_contrat", nullable = false)
    private Integer montantContrat;

    @ManyToOne
    private Etudiant etudiant;
}

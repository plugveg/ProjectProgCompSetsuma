package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Universite")
@Data
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;

    @Column(name = "nom_univ", nullable = false)
    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departements;
}

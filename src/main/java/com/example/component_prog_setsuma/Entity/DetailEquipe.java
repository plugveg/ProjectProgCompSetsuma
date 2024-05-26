package com.example.component_prog_setsuma.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "detail_equipe")
@Data
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailEquipe;

    @Column(name = "salle", nullable = false)
    private Integer salle;

    @Column(name = "thematique", nullable = false)
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;
}

package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "faculte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_faculte", nullable = false)
    private String nomFaculte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universite")
    private Universite universite;
}


package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "salle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="no_salle", nullable = false)
    private String noSalle;

    @Column(name="capacite")
    private int capacite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departement")
    private Departement departement;
}

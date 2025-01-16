package com.project.gestion_examens.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveillanceEnseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enseignant_id", nullable = false)
    private Enseignant enseignant;

    @Basic
    @Column(nullable = false)
    private LocalDateTime startTime;

    @Basic
    @Column(nullable = false)
    private LocalDateTime endTime;

    @Basic
    @Column(nullable = false)
    private int dureeExamen; // en heures
}

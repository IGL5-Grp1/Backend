package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "matiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "coeff")
    private float coeff;

    // Relation avec Section
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_section")
    private Section section;

    // Autres relations ou attributs si nécessaire
}

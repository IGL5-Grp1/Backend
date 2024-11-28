package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

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

    // Relation avec SectionMatiere
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SectionMatiere> sectionMatieres;
}

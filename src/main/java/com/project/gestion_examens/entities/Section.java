package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "section")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Filiere
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;

    // Relation avec Niveau
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    // Autres attributs
    @Column(name = "nom", nullable = false)
    private String nom;

    // Relation avec SectionMatiere
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SectionMatiere> sectionMatieres;
}

package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "section_matiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionMatiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Section
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    // Relation avec Matiere
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    // Vous pouvez ajouter des attributs supplémentaires si nécessaire
    // Par exemple, un attribut pour la date d'association
    // @Column(name = "date_association")
    // private LocalDate dateAssociation;
}

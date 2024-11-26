package com.project.gestion_examens.entities;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "grade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_grade", nullable = false)
    private String nomGrade;

    @Column(name="nb_heures_etude_a_faire")
    private int nbHeuresEtudeAFaire;

    @Column(name="nb_heures_surveillance_a_faire")
    private int nbHeuresSurveillanceAFaire;

    // Relation avec HistorisationProf
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude  // Évite les boucles infinies lors du toString()
    @EqualsAndHashCode.Exclude  // Évite les problèmes lors de l'utilisation dans des collections
    private List<HistorisationProf> historisationsProf;
}

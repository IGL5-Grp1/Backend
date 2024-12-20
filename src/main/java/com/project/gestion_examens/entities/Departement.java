package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_dept", nullable = false)
    private String nomDept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faculte")
    private Faculte faculte;

    // Relation avec HistorisationProf
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude  // Évite les boucles infinies lors du toString()
    @EqualsAndHashCode.Exclude  // Évite les problèmes lors de l'utilisation dans des collections
    private List<Enseignant> enseignants;
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Section> sections;
}

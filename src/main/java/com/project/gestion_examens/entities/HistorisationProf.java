package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historisation_prof")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorisationProf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professeur")
    private Professeur professeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departement")
    private Departement departement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grade")
    private Grade grade;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;
}

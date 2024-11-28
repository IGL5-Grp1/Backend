package com.project.gestion_examens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // Other attributes
    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "niveau", nullable = false)
    private Integer niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false) // FK column name
    private Departement departement;

    // Renamed the column to avoid SQL reserved keyword conflict
    @Column(name = "group_number", nullable = false)
    private Integer groupNumber;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SectionMatiere> sectionMatieres;
}

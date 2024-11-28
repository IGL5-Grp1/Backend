package com.project.gestion_examens.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "filiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom", nullable = false)
    private String nom;

    @Column(name="description")
    private String description;

    // Relation avec Section
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Section> sections;
}

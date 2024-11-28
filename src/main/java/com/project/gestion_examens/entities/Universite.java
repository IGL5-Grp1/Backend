package com.project.gestion_examens.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "universite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_universite", nullable = false)
    private String nomUniversite;

    @Column(name="region", nullable = false)
    private String region;

    @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Faculte> facultes;
}

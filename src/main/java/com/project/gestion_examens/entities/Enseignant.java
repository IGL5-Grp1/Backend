package com.project.gestion_examens.entities;


import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "enseignant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enseignant_id",nullable = false)
    private Long id;
    @Basic
    @Column(name = "nom",nullable = false,length = 45)
    private String nom;
    @Basic
    @Column(name = "prenom",nullable = false,length = 45)
    private String prenom;

    @Basic
    @Column(name = "cin",nullable = false,length = 45)
    private String cin;
    @OneToOne(cascade = CascadeType.REMOVE) // in case we want to remove an professor , we remove that instructor to be automatically removed as well
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",nullable = false)
    private User user ;
}

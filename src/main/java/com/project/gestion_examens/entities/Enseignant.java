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
    @Column(name = "enseignant_id")
    private Long id;
    @Basic
    @Column(name = "username",nullable = false,length = 45)
    private String username;

    @Basic
    @Column(name = "cin",nullable = false,length = 45)
    private String cin;

    @Basic
    @Column(name = "email",nullable = false,length = 45)
    private String email;

}

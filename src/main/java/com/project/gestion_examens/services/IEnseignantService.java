package com.project.gestion_examens.services;

import com.project.gestion_examens.entities.Enseignant;

import java.util.List;

public interface IEnseignantService {
    Enseignant saveEnseignant(Enseignant Enseignant);
    List<Enseignant> findAll();
    Enseignant findById(Long id);
    void deleteById(Long id);
    List<Enseignant> findByEmail(String email);
    List<Enseignant> findByUsername(String username);
    void update(Enseignant Enseignant);
}

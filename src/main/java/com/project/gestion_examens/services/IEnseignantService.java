package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.request.AddEnseignantDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Enseignant;

import java.util.List;

public interface IEnseignantService {
    EnseignantResponseDTO saveEnseignant(AddEnseignantDTO addEnseignantDTO);
    List<EnseignantResponseDTO> findAll();
    Enseignant findById(Long id);
    void deleteById(Long id);
    List<Enseignant> findByEmail(String email);
    List<Enseignant> findByUsername(String username);
    void update(Enseignant Enseignant);
}

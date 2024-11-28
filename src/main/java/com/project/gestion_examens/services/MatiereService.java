package com.project.gestion_examens.services;


import com.project.gestion_examens.dto.MatiereDTO;

import java.util.List;

public interface MatiereService {

    MatiereDTO saveMatiere(MatiereDTO matiereDTO);

    MatiereDTO getMatiereById(Long id);

    List<MatiereDTO> getAllMatieres();

    MatiereDTO updateMatiere(Long id, MatiereDTO matiereDTO);

    void deleteMatiere(Long id);
}

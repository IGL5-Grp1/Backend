package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.MatiereDTO;
import com.project.gestion_examens.entities.Matiere;
import com.project.gestion_examens.repositories.MatiereRepository;
import com.project.gestion_examens.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    @Override
    public MatiereDTO saveMatiere(MatiereDTO matiereDTO) {
        Matiere matiere = matiereDTO.toEntity();
        matiere = matiereRepository.save(matiere);
        return MatiereDTO.fromEntity(matiere);
    }

    @Override
    public MatiereDTO getMatiereById(Long id) {
        Matiere matiere = matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
        return MatiereDTO.fromEntity(matiere);
    }

    @Override
    public List<MatiereDTO> getAllMatieres() {
        List<Matiere> matieres = matiereRepository.findAll();
        return matieres.stream()
                .map(MatiereDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MatiereDTO updateMatiere(Long id, MatiereDTO matiereDTO) {
        Matiere existingMatiere = matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));

        existingMatiere.setName(matiereDTO.getName());
        existingMatiere.setCoeff(matiereDTO.getCoeff());
        // Ne pas mettre à jour sectionMatieres ici pour éviter les problèmes

        existingMatiere = matiereRepository.save(existingMatiere);
        return MatiereDTO.fromEntity(existingMatiere);
    }

    @Override
    public void deleteMatiere(Long id) {
        Matiere matiere = matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
        matiereRepository.delete(matiere);
    }
}

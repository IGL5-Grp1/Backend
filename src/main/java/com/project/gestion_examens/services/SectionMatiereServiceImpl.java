package com.project.gestion_examens.services;


import com.project.gestion_examens.dto.SectionMatiereDTO;
import com.project.gestion_examens.entities.Matiere;
import com.project.gestion_examens.entities.Section;
import com.project.gestion_examens.entities.SectionMatiere;
import com.project.gestion_examens.repositories.MatiereRepository;
import com.project.gestion_examens.repositories.SectionMatiereRepository;
import com.project.gestion_examens.repositories.SectionRepository;
import com.project.gestion_examens.services.SectionMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionMatiereServiceImpl implements SectionMatiereService {

    @Autowired
    private SectionMatiereRepository sectionMatiereRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    @Override
    public SectionMatiereDTO saveSectionMatiere(SectionMatiereDTO sectionMatiereDTO) {
        SectionMatiere sectionMatiere = sectionMatiereDTO.toEntity();

        // Récupération des entités Section et Matiere associées
        Section section = sectionRepository.findById(sectionMatiereDTO.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section non trouvée"));
        Matiere matiere = matiereRepository.findById(sectionMatiereDTO.getMatiereId())
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));

        sectionMatiere.setSection(section);
        sectionMatiere.setMatiere(matiere);

        sectionMatiere = sectionMatiereRepository.save(sectionMatiere);
        return SectionMatiereDTO.fromEntity(sectionMatiere);
    }

    @Override
    public SectionMatiereDTO getSectionMatiereById(Long id) {
        SectionMatiere sectionMatiere = sectionMatiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SectionMatiere non trouvée"));
        return SectionMatiereDTO.fromEntity(sectionMatiere);
    }

    @Override
    public List<SectionMatiereDTO> getAllSectionMatieres() {
        List<SectionMatiere> sectionMatieres = sectionMatiereRepository.findAll();
        return sectionMatieres.stream()
                .map(SectionMatiereDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SectionMatiereDTO updateSectionMatiere(Long id, SectionMatiereDTO sectionMatiereDTO) {
        SectionMatiere existingSectionMatiere = sectionMatiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SectionMatiere non trouvée"));

        // Récupération des nouvelles entités Section et Matiere si elles ont changé
        if (!existingSectionMatiere.getSection().getId().equals(sectionMatiereDTO.getSectionId())) {
            Section section = sectionRepository.findById(sectionMatiereDTO.getSectionId())
                    .orElseThrow(() -> new RuntimeException("Section non trouvée"));
            existingSectionMatiere.setSection(section);
        }

        if (!existingSectionMatiere.getMatiere().getId().equals(sectionMatiereDTO.getMatiereId())) {
            Matiere matiere = matiereRepository.findById(sectionMatiereDTO.getMatiereId())
                    .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
            existingSectionMatiere.setMatiere(matiere);
        }

        existingSectionMatiere = sectionMatiereRepository.save(existingSectionMatiere);
        return SectionMatiereDTO.fromEntity(existingSectionMatiere);
    }

    @Override
    public void deleteSectionMatiere(Long id) {
        SectionMatiere sectionMatiere = sectionMatiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SectionMatiere non trouvée"));
        sectionMatiereRepository.delete(sectionMatiere);
    }
}

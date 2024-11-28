package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.SectionMatiereDTO;

import java.util.List;

public interface SectionMatiereService {

    SectionMatiereDTO saveSectionMatiere(SectionMatiereDTO sectionMatiereDTO);

    SectionMatiereDTO getSectionMatiereById(Long id);

    List<SectionMatiereDTO> getAllSectionMatieres();

    SectionMatiereDTO updateSectionMatiere(Long id, SectionMatiereDTO sectionMatiereDTO);

    void deleteSectionMatiere(Long id);
}

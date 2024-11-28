package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.SectionDTO;

import java.util.List;

public interface SectionService {
    SectionDTO saveSection(SectionDTO sectionDTO);

    SectionDTO getSectionById(Long id);

    List<SectionDTO> getAllSections();

    SectionDTO updateSection(Long id, SectionDTO sectionDTO);

    void deleteSection(Long id);

}

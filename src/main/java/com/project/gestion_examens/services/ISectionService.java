package com.project.gestion_examens.services;

import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Section;

import java.util.List;

public interface ISectionService {
    Section findById(Long id);
    List<Section> findAllByNiveau(int niveau);
    List<Section> findAllByDepartement(Departement departement);
    Section saveSection(Section section);
    void updateSection(Section section);
    void deleteSection(Long id);
    List<Section> findAll();
}

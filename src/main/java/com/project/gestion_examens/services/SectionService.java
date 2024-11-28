package com.project.gestion_examens.services;

import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Section;
import com.project.gestion_examens.repositories.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SectionService implements ISectionService {
    SectionRepository SectionRepository;
    @Override
    public Section findById(Long id) {
        return SectionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Section> findAllByNiveau(int niveau) {
        return SectionRepository.findAllByNiveau(niveau);
    }

    @Override
    public List<Section> findAllByDepartement(Departement departement) {
        return SectionRepository.findAllByDepartement(departement);
    }

    @Override
    public Section saveSection(Section section) {
        return SectionRepository.save(section);
    }

    @Override
    public void updateSection(Section section) {
        Section target = SectionRepository.findById(section.getId()).orElseThrow();
        target.setNiveau(section.getNiveau());
        target.setDepartement(section.getDepartement());
        target.setNom(section.getNom());
        target.setGroupNumber(section.getGroupNumber());
        SectionRepository.save(target);
    }

    @Override
    public void deleteSection(Long id) {
        Section target = SectionRepository.findById(id).orElseThrow();
        SectionRepository.delete(target);
    }

    @Override
    public List<Section> findAll() {
        return SectionRepository.findAll();
    }
}

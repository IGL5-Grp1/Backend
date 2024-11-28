package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.SectionDTO;
import com.project.gestion_examens.entities.Section;
import com.project.gestion_examens.mapper.SectionMapper;
import com.project.gestion_examens.repositories.SectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public SectionDTO saveSection(SectionDTO sectionDTO) {
        Section section = SectionMapper.toEntity(sectionDTO);
        section = sectionRepository.save(section);
        return SectionMapper.toDTO(section);
    }

    @Override
    public SectionDTO getSectionById(Long id) {
        Section section = sectionRepository.findById(id).orElse(null);
        return SectionMapper.toDTO(section);
    }

    @Override
    public List<SectionDTO> getAllSections() {
        List<Section> sections = sectionRepository.findAll();
        return sections.stream()
                .map(SectionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDTO updateSection(Long id, SectionDTO sectionDTO) {
        Section section = sectionRepository.findById(id).orElse(null);
        if (section != null) {
            section.setNom(sectionDTO.getNom());
            section.setNiveau(sectionDTO.getNiveau());
            section = sectionRepository.save(section);
            return SectionMapper.toDTO(section);
        }
        return null;
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
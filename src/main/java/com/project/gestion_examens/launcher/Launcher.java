package com.project.gestion_examens.launcher;

import com.project.gestion_examens.dto.SectionDTO;
import com.project.gestion_examens.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Launcher implements CommandLineRunner {

    @Autowired
    private SectionService sectionService;

    @Override
    public void run(String... args) throws Exception {
        createSections();
        getSectionById(1L);
        getAllSections();
        updateSection(2L);
        deleteSection(3L);
    }

    private void createSections() {
        for (int i = 0; i < 5; i++) {
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setNom("Section " + i);
            sectionDTO.setNiveau("Niveau " + i);
            sectionService.saveSection(sectionDTO);
        }
    }

    private void getSectionById(Long id) {
        SectionDTO sectionDTO = sectionService.getSectionById(id);
        if (sectionDTO != null) {
            System.out.println("Section found: " + sectionDTO.getNom());
        } else {
            System.out.println("Section not found with id: " + id);
        }
    }

    private void getAllSections() {
        sectionService.getAllSections().forEach(sectionDTO -> {
            System.out.println("Section: " + sectionDTO.getNom());
        });
    }

    private void updateSection(Long id) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setNom("Updated Section");
        sectionDTO.setNiveau("Updated Niveau");
        SectionDTO updatedSection = sectionService.updateSection(id, sectionDTO);
        if (updatedSection != null) {
            System.out.println("Section updated: " + updatedSection.getNom());
        } else {
            System.out.println("Section not found with id: " + id);
        }
    }

    private void deleteSection(Long id) {
        sectionService.deleteSection(id);
        System.out.println("Section deleted with id: " + id);
    }
}
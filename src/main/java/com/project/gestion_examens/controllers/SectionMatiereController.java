package com.project.gestion_examens.controllers;


import com.project.gestion_examens.dto.SectionMatiereDTO;
import com.project.gestion_examens.services.SectionMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section-matieres")
public class SectionMatiereController {

    @Autowired
    private SectionMatiereService sectionMatiereService;

    @PostMapping
    public SectionMatiereDTO createSectionMatiere(@RequestBody SectionMatiereDTO sectionMatiereDTO) {
        return sectionMatiereService.saveSectionMatiere(sectionMatiereDTO);
    }

    @GetMapping("/{id}")
    public SectionMatiereDTO getSectionMatiereById(@PathVariable Long id) {
        return sectionMatiereService.getSectionMatiereById(id);
    }

    @GetMapping
    public List<SectionMatiereDTO> getAllSectionMatieres() {
        return sectionMatiereService.getAllSectionMatieres();
    }

    @PutMapping("/{id}")
    public SectionMatiereDTO updateSectionMatiere(@PathVariable Long id, @RequestBody SectionMatiereDTO sectionMatiereDTO) {
        return sectionMatiereService.updateSectionMatiere(id, sectionMatiereDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSectionMatiere(@PathVariable Long id) {
        sectionMatiereService.deleteSectionMatiere(id);
    }
}

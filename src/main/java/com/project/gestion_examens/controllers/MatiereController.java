package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.MatiereDTO;
import com.project.gestion_examens.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @PostMapping
    public MatiereDTO createMatiere(@RequestBody MatiereDTO matiereDTO) {
        return matiereService.saveMatiere(matiereDTO);
    }

    @GetMapping("/{id}")
    public MatiereDTO getMatiereById(@PathVariable Long id) {
        return matiereService.getMatiereById(id);
    }

    @GetMapping
    public List<MatiereDTO> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @PutMapping("/{id}")
    public MatiereDTO updateMatiere(@PathVariable Long id, @RequestBody MatiereDTO matiereDTO) {
        return matiereService.updateMatiere(id, matiereDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
    }
}

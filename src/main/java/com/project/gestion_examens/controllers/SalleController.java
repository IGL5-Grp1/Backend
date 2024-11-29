package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.SalleDTO;
import com.project.gestion_examens.services.impl.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@PreAuthorize("hasRole('DepartmentAdmin')")
@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService salleService;

    // Create Salle
    @PostMapping
    public ResponseEntity<SalleDTO> createSalle(@RequestBody SalleDTO salleDto) {
        SalleDTO createdSalle = salleService.createSalle(salleDto);
        return new ResponseEntity<>(createdSalle, HttpStatus.CREATED);
    }

    // Get Salle by ID
    @GetMapping("/{id}")
    public ResponseEntity<SalleDTO> getSalleById(@PathVariable Long id) {
        SalleDTO salleDto = salleService.getSalleById(id);
        return new ResponseEntity<>(salleDto, HttpStatus.OK);
    }

    // Get All Salles
    @GetMapping
    public ResponseEntity<List<SalleDTO>> getAllSalles() {
        List<SalleDTO> salles = salleService.getAllSalles();
        return new ResponseEntity<>(salles, HttpStatus.OK);
    }

    // Update Salle
    @PutMapping("/{id}")
    public ResponseEntity<SalleDTO> updateSalle(@PathVariable Long id, @RequestBody SalleDTO salleDto) {
        SalleDTO updatedSalle = salleService.updateSalle(id, salleDto);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
    }

    // Delete Salle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

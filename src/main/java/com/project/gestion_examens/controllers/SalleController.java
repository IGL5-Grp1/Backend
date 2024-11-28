package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.SalleDto;
import com.project.gestion_examens.services.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
@RequiredArgsConstructor
public class SalleController {

    private final SalleService salleService;

    // Create Salle
    @PostMapping
    public ResponseEntity<SalleDto> createSalle(@RequestBody SalleDto salleDto) {
        SalleDto createdSalle = salleService.createSalle(salleDto);
        return new ResponseEntity<>(createdSalle, HttpStatus.CREATED);
    }

    // Get Salle by ID
    @GetMapping("/{id}")
    public ResponseEntity<SalleDto> getSalleById(@PathVariable Long id) {
        SalleDto salleDto = salleService.getSalleById(id);
        return new ResponseEntity<>(salleDto, HttpStatus.OK);
    }

    // Get All Salles
    @GetMapping
    public ResponseEntity<List<SalleDto>> getAllSalles() {
        List<SalleDto> salles = salleService.getAllSalles();
        return new ResponseEntity<>(salles, HttpStatus.OK);
    }

    // Update Salle
    @PutMapping("/{id}")
    public ResponseEntity<SalleDto> updateSalle(@PathVariable Long id, @RequestBody SalleDto salleDto) {
        SalleDto updatedSalle = salleService.updateSalle(id, salleDto);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
    }

    // Delete Salle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

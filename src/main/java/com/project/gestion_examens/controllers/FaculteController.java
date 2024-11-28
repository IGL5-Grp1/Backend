package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.FaculteDTO;
import com.project.gestion_examens.services.impl.FaculteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facultes")
@RequiredArgsConstructor
public class FaculteController {

    private final FaculteService faculteService;

    // Create Faculte
    @PostMapping
    public ResponseEntity<FaculteDTO> createFaculte(@RequestBody FaculteDTO faculteDto) {
        FaculteDTO createdFaculte = faculteService.createFaculte(faculteDto);
        return new ResponseEntity<>(createdFaculte, HttpStatus.CREATED);
    }

    // Get Faculte by ID
    @GetMapping("/{id}")
    public ResponseEntity<FaculteDTO> getFaculteById(@PathVariable Long id) {
        FaculteDTO faculteDto = faculteService.getFaculteById(id);
        return new ResponseEntity<>(faculteDto, HttpStatus.OK);
    }

    // Get All Facultes
    @GetMapping
    public ResponseEntity<List<FaculteDTO>> getAllFacultes() {
        List<FaculteDTO> facultes = faculteService.getAllFacultes();
        return new ResponseEntity<>(facultes, HttpStatus.OK);
    }

    // Update Faculte
    @PutMapping("/{id}")
    public ResponseEntity<FaculteDTO> updateFaculte(@PathVariable Long id, @RequestBody FaculteDTO faculteDto) {
        FaculteDTO updatedFaculte = faculteService.updateFaculte(id, faculteDto);
        return new ResponseEntity<>(updatedFaculte, HttpStatus.OK);
    }

    // Delete Faculte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculte(@PathVariable Long id) {
        faculteService.deleteFaculte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
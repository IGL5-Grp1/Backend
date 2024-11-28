package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.FaculteDto;
import com.project.gestion_examens.services.FaculteService;
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
    public ResponseEntity<FaculteDto> createFaculte(@RequestBody FaculteDto faculteDto) {
        FaculteDto createdFaculte = faculteService.createFaculte(faculteDto);
        return new ResponseEntity<>(createdFaculte, HttpStatus.CREATED);
    }

    // Get Faculte by ID
    @GetMapping("/{id}")
    public ResponseEntity<FaculteDto> getFaculteById(@PathVariable Long id) {
        FaculteDto faculteDto = faculteService.getFaculteById(id);
        return new ResponseEntity<>(faculteDto, HttpStatus.OK);
    }

    // Get All Facultes
    @GetMapping
    public ResponseEntity<List<FaculteDto>> getAllFacultes() {
        List<FaculteDto> facultes = faculteService.getAllFacultes();
        return new ResponseEntity<>(facultes, HttpStatus.OK);
    }

    // Update Faculte
    @PutMapping("/{id}")
    public ResponseEntity<FaculteDto> updateFaculte(@PathVariable Long id, @RequestBody FaculteDto faculteDto) {
        FaculteDto updatedFaculte = faculteService.updateFaculte(id, faculteDto);
        return new ResponseEntity<>(updatedFaculte, HttpStatus.OK);
    }

    // Delete Faculte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculte(@PathVariable Long id) {
        faculteService.deleteFaculte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
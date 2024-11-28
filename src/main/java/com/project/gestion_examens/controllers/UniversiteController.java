package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.UniversiteDto;
import com.project.gestion_examens.services.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/universite")
@RequiredArgsConstructor
public class UniversiteController {

    private final UniversiteService universiteService;

    // Create Universite
    @PostMapping
    public ResponseEntity<UniversiteDto> createUniversite(@RequestBody UniversiteDto universiteDto) {
        UniversiteDto createdUniversite = universiteService.createUniversite(universiteDto);
        return new ResponseEntity<>(createdUniversite, HttpStatus.CREATED);
    }

    // Get Universite by ID
    @GetMapping("/{id}")
    public ResponseEntity<UniversiteDto> getUniversiteById(@PathVariable Long id) {
        UniversiteDto universiteDto = universiteService.getUniversiteById(id);
        return new ResponseEntity<>(universiteDto, HttpStatus.OK);
    }

    // Get All Universites
    @GetMapping
    public ResponseEntity<List<UniversiteDto>> getAllUniversites() {
        List<UniversiteDto> universites = universiteService.getAllUniversites();
        return new ResponseEntity<>(universites, HttpStatus.OK);
    }

    // Update Universite
    @PutMapping("/{id}")
    public ResponseEntity<UniversiteDto> updateUniversite(@PathVariable Long id, @RequestBody UniversiteDto universiteDto) {
        UniversiteDto updatedUniversite = universiteService.updateUniversite(id, universiteDto);
        return new ResponseEntity<>(updatedUniversite, HttpStatus.OK);
    }

    // Delete Universite
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

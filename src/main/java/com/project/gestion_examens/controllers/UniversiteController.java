package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.UniversiteDTO;
import com.project.gestion_examens.services.impl.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RequiredArgsConstructor
@PreAuthorize("hasRole('UniversityAdmin')")
@RestController@RequestMapping("/universite")
public class UniversiteController {

    private final UniversiteService universiteService;

    // Create Universite
    @PostMapping
    public ResponseEntity<UniversiteDTO> createUniversite(@RequestBody UniversiteDTO universiteDto) {
        UniversiteDTO createdUniversite = universiteService.createUniversite(universiteDto);
        return new ResponseEntity<>(createdUniversite, HttpStatus.CREATED);
    }

    // Get Universite by ID
    @GetMapping("/{id}")
    public ResponseEntity<UniversiteDTO> getUniversiteById(@PathVariable Long id) {
        UniversiteDTO universiteDto = universiteService.getUniversiteById(id);
        return new ResponseEntity<>(universiteDto, HttpStatus.OK);
    }

    // Get All Universites
    @GetMapping
    public ResponseEntity<List<UniversiteDTO>> getAllUniversites() {
        List<UniversiteDTO> universites = universiteService.getAllUniversites();
        return new ResponseEntity<>(universites, HttpStatus.OK);
    }

    // Update Universite
    @PutMapping("/{id}")
    public ResponseEntity<UniversiteDTO> updateUniversite(@PathVariable Long id, @RequestBody UniversiteDTO universiteDto) {
        UniversiteDTO updatedUniversite = universiteService.updateUniversite(id, universiteDto);
        return new ResponseEntity<>(updatedUniversite, HttpStatus.OK);
    }

    // Delete Universite
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

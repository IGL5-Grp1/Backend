package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.UniversiteDTO;
import com.project.gestion_examens.entities.Universite;
import com.project.gestion_examens.repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/universite")
@Transactional
@RequiredArgsConstructor
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    // Create Universite
    public UniversiteDTO createUniversite(@NotNull UniversiteDTO universiteDto) {
        Universite universite = new Universite();
        universite.setNomUniversite(universiteDto.getNomUniversite());
        universite.setRegion(universiteDto.getRegion());
        Universite savedUniversite = universiteRepository.save(universite);
        return mapToDto(savedUniversite);
    }

    // Get Universite by ID
    public UniversiteDTO getUniversiteById(Long id) {
        Universite universite = universiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Universite not found with id: " + id));
        return mapToDto(universite);
    }

    // Get All Universites
    public List<UniversiteDTO> getAllUniversites() {
        return universiteRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Update Universite
    public UniversiteDTO updateUniversite(Long id, @NotNull UniversiteDTO universiteDto) {
        Universite universite = universiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Universite not found with id: " + id));
        universite.setNomUniversite(universiteDto.getNomUniversite());
        universite.setRegion(universiteDto.getRegion());
        Universite updatedUniversite = universiteRepository.save(universite);
        return mapToDto(updatedUniversite);
    }

    // Delete Universite
    public void deleteUniversite(Long id) {
        Universite universite = universiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Universite not found with id: " + id));
        universiteRepository.delete(universite);
    }

    // Helper method to map Universite to UniversiteDto
    private UniversiteDTO mapToDto(@NotNull Universite universite) {
        return new UniversiteDTO(universite.getId(), universite.getNomUniversite(), universite.getRegion());
    }
}
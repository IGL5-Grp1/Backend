package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.FaculteDto;
import com.project.gestion_examens.entities.Faculte;
import com.project.gestion_examens.entities.Universite;
import com.project.gestion_examens.repositories.FaculteRepository;
import com.project.gestion_examens.repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FaculteService {

    private final FaculteRepository faculteRepository;
    private final UniversiteRepository universiteRepository;

    // Create Faculte
    public FaculteDto createFaculte(FaculteDto faculteDto) {
        Universite universite = universiteRepository.findById(faculteDto.getUniversiteId())
                .orElseThrow(() -> new EntityNotFoundException("Universite not found with id: " + faculteDto.getUniversiteId()));

        Faculte faculte = new Faculte();
        faculte.setNomFaculte(faculteDto.getNomFaculte());
        faculte.setUniversite(universite);

        Faculte savedFaculte = faculteRepository.save(faculte);
        return mapToDto(savedFaculte);
    }

    // Get Faculte by ID
    public FaculteDto getFaculteById(Long id) {
        Faculte faculte = faculteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculte not found with id: " + id));
        return mapToDto(faculte);
    }

    // Get All Facultes
    public List<FaculteDto> getAllFacultes() {
        return faculteRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Update Faculte
    public FaculteDto updateFaculte(Long id, FaculteDto faculteDto) {
        Faculte faculte = faculteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculte not found with id: " + id));

        Universite universite = universiteRepository.findById(faculteDto.getUniversiteId())
                .orElseThrow(() -> new EntityNotFoundException("Universite not found with id: " + faculteDto.getUniversiteId()));

        faculte.setNomFaculte(faculteDto.getNomFaculte());
        faculte.setUniversite(universite);

        Faculte updatedFaculte = faculteRepository.save(faculte);
        return mapToDto(updatedFaculte);
    }

    // Delete Faculte
    public void deleteFaculte(Long id) {
        Faculte faculte = faculteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculte not found with id: " + id));
        faculteRepository.delete(faculte);
    }

    // Helper method to map Faculte to FaculteDto
    private FaculteDto mapToDto(Faculte faculte) {
        return new FaculteDto(
                faculte.getId(),
                faculte.getNomFaculte(),
                faculte.getUniversite() != null ? faculte.getUniversite().getId() : null
        );
    }
}

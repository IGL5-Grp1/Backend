package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.DepartementDto;
import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Faculte;
import com.project.gestion_examens.repositories.DepartementRepository;
import com.project.gestion_examens.repositories.FaculteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepository departementRepository;
    private final FaculteRepository faculteRepository;

    // Create Departement
    public DepartementDto createDepartement(DepartementDto departementDto) {
        Faculte faculte = faculteRepository.findById(departementDto.getFaculteId())
                .orElseThrow(() -> new EntityNotFoundException("Faculte not found with id: " + departementDto.getFaculteId()));

        Departement departement = new Departement();
        departement.setNomDept(departementDto.getNomDept());
        departement.setFaculte(faculte);

        Departement savedDepartement = departementRepository.save(departement);
        return mapToDto(savedDepartement);
    }

    // Get Departement by ID
    public DepartementDto getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id));
        return mapToDto(departement);
    }

    // Get All Departements
    public List<DepartementDto> getAllDepartements() {
        return departementRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Update Departement
    public DepartementDto updateDepartement(Long id, DepartementDto departementDto) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id));

        Faculte faculte = faculteRepository.findById(departementDto.getFaculteId())
                .orElseThrow(() -> new EntityNotFoundException("Faculte not found with id: " + departementDto.getFaculteId()));

        departement.setNomDept(departementDto.getNomDept());
        departement.setFaculte(faculte);

        Departement updatedDepartement = departementRepository.save(departement);
        return mapToDto(updatedDepartement);
    }

    // Delete Departement
    public void deleteDepartement(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id));
        departementRepository.delete(departement);
    }

    // Helper method to map Departement to DepartementDto
    private DepartementDto mapToDto(Departement departement) {
        return new DepartementDto(
                departement.getId(),
                departement.getNomDept(),
                departement.getFaculte() != null ? departement.getFaculte().getId() : null
        );
    }
}

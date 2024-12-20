package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.SalleDTO;
import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Salle;
import com.project.gestion_examens.repositories.DepartementRepository;
import com.project.gestion_examens.repositories.SalleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalleService {

    private final SalleRepository salleRepository;
    private final DepartementRepository departementRepository;

    // Create Salle
    public SalleDTO createSalle(SalleDTO salleDto) {
        Departement departement = departementRepository.findById(salleDto.getDepartementId())
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + salleDto.getDepartementId()));

        Salle salle = new Salle();
        salle.setNoSalle(salleDto.getNoSalle());
        salle.setCapacite(salleDto.getCapacite());
        salle.setDepartement(departement);

        Salle savedSalle = salleRepository.save(salle);
        return mapToDto(savedSalle);
    }

    // Get Salle by ID
    public SalleDTO getSalleById(Long id) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salle not found with id: " + id));
        return mapToDto(salle);
    }

    // Get All Salles
    public List<SalleDTO> getAllSalles() {
        return salleRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Update Salle
    public SalleDTO updateSalle(Long id, SalleDTO salleDto) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salle not found with id: " + id));

        Departement departement = departementRepository.findById(salleDto.getDepartementId())
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + salleDto.getDepartementId()));

        salle.setNoSalle(salleDto.getNoSalle());
        salle.setCapacite(salleDto.getCapacite());
        salle.setDepartement(departement);

        Salle updatedSalle = salleRepository.save(salle);
        return mapToDto(updatedSalle);
    }

    // Delete Salle
    public void deleteSalle(Long id) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salle not found with id: " + id));
        salleRepository.delete(salle);
    }

    // Helper method to map Salle to SalleDto
    private SalleDTO mapToDto(Salle salle) {
        return new SalleDTO(
                salle.getId(),
                salle.getNoSalle(),
                salle.getCapacite(),
                salle.getDepartement() != null ? salle.getDepartement().getId() : null
        );
    }
}

package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.request.AddEnseignantDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.entities.Grade;
import com.project.gestion_examens.mappers.EnseignatMapper;
import com.project.gestion_examens.repositories.DepartementRepository;
import com.project.gestion_examens.repositories.EnseignantRepository;
import com.project.gestion_examens.repositories.GradeRepository;
import com.project.gestion_examens.services.IEnseignantService;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnseignantService implements IEnseignantService {
    private final DepartementRepository departementRepository;
    EnseignantRepository EnseignantRepository;
    EnseignatMapper enseignatMapper;
    GradeRepository gradeRepository;

    @Override
    public EnseignantResponseDTO saveEnseignant(AddEnseignantDTO addEnseignantDTO) {
        Departement departement = departementRepository.findById(addEnseignantDTO.departmentId())
                .orElseThrow(() -> new InvalidRequestStateException("Department not found with id: " + addEnseignantDTO.departmentId()));

        // Validate grade exists
        Grade grade = gradeRepository.findById(addEnseignantDTO.gradeId())
                .orElseThrow(() -> new InvalidRequestStateException("Grade not found with id: " + addEnseignantDTO.gradeId()));

        // Create and save new enseignant
        Enseignant enseignant = new Enseignant();
        enseignant.setUsername(addEnseignantDTO.username());
        enseignant.setEmail(addEnseignantDTO.email());
        enseignant.setCin(addEnseignantDTO.cin());
        enseignant.setDepartement(departement);
        enseignant.setGrade(grade);

        return enseignatMapper.toEnseignantResponseDTO(EnseignantRepository.save(enseignant));
    }

    @Override
    public List<EnseignantResponseDTO> findAll() {
        List<Enseignant> enseignants = EnseignantRepository.findAll();
        return enseignatMapper.toEnseignantListResponseDTO(enseignants);
    }

    @Override
    public Enseignant findById(Long id) {
        return EnseignantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Enseignant Enseignant = EnseignantRepository.findById(id).orElseThrow();
        EnseignantRepository.delete(Enseignant);
    }

    @Override
    public List<Enseignant> findByEmail(String email) {
        return EnseignantRepository.findByEmail(email);
    }

    @Override
    public List<Enseignant> findByUsername(String username) {
        return EnseignantRepository.findByUsername(username);
    }

    @Override
    public void update(Enseignant Enseignant) {
        Enseignant target = EnseignantRepository.findById(Enseignant.getId()).orElseThrow();
        target.setEmail(Enseignant.getEmail());
        target.setUsername(Enseignant.getUsername());
        target.setCin(Enseignant.getCin());
        EnseignantRepository.save(target);
    }
}

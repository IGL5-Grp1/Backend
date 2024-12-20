package com.project.gestion_examens.services.impl;
import com.project.gestion_examens.dto.request.AddEnseignantDTO;
<<<<<<< Updated upstream
=======
import com.project.gestion_examens.dto.response.CSVUploadResponseDTO;
>>>>>>> Stashed changes
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.entities.Grade;
import com.project.gestion_examens.mappers.EnseignatMapper;
import com.project.gestion_examens.repositories.DepartementRepository;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.mappers.EnseignatMapper;
import com.project.gestion_examens.repositories.EnseignantRepository;
import com.project.gestion_examens.repositories.GradeRepository;
import com.project.gestion_examens.services.IEnseignantService;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
<<<<<<< Updated upstream
=======
    }
    public CSVUploadResponseDTO processCSVFile(MultipartFile file) {
        List<String> errors = new ArrayList<>();
        int successCount = 0;
        int totalProcessed = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Skip the header line
            String headerLine = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                totalProcessed++;
                try {
                    processLine(line.split(","));
                    successCount++;
                } catch (Exception e) {
                    errors.add("Line " + totalProcessed + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to process CSV file: " + e.getMessage());
        }

        return CSVUploadResponseDTO.builder()
                .totalProcessed(totalProcessed)
                .successCount(successCount)
                .errors(errors)
                .build();
    }

    private void processLine(String[] fields) {
        if (fields.length != 5) {
            throw new IllegalArgumentException("Invalid number of fields. Expected 5 fields: username,email,cin,departmentId,gradeId");
        }
        // Parse fields
        String username = fields[0].trim();
        String email = fields[1].trim();
        String cin = fields[2].trim();
        Long departmentId = Long.parseLong(fields[3].trim());
        Long gradeId = Long.parseLong(fields[4].trim());

        // Validate fields
        if (username.isEmpty() || email.isEmpty() || cin.isEmpty()) {
            throw new IllegalArgumentException("Username, email, and CIN are required");
        }

        saveEnseignant(AddEnseignantDTO.builder()
                .username(username)
                .email(email)
                .cin(cin)
                .departmentId(departmentId)
                .gradeId(gradeId)
                .build());
>>>>>>> Stashed changes
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

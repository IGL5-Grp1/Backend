package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.request.AddEnseignantDTO;
import com.project.gestion_examens.dto.response.CSVUploadResponseDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.services.impl.EnseignantService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SecurityRequirement(name = "Access Token Authorization")
@RequiredArgsConstructor
@PreAuthorize("hasRole(T(com.project.gestion_examens.entities.Role$RoleName).DepartmentAdmin.name())")
@RestController@RequestMapping("/enseignant")
public class EnseignantController {
    @Autowired
    EnseignantService EnseignantService;

    @PostMapping("add")
    public EnseignantResponseDTO addEnseignant(@RequestBody AddEnseignantDTO addEnseignantDTO) {
        return EnseignantService.saveEnseignant(addEnseignantDTO);
    }
    @PostMapping("/upload")
    public ResponseEntity<CSVUploadResponseDTO> uploadCSV(
            @RequestParam("file") MultipartFile file) {
        // Validate file
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    CSVUploadResponseDTO.builder()
                            .totalProcessed(0)
                            .successCount(0)
                            .errors(List.of("Please select a file to upload"))
                            .build()
            );
        }

        // Validate file type
        String contentType = file.getContentType();
        if (contentType == null || !contentType.equals("text/csv")) {
            return ResponseEntity.badRequest().body(
                    CSVUploadResponseDTO.builder()
                            .totalProcessed(0)
                            .successCount(0)
                            .errors(List.of("Please upload a CSV file"))
                            .build()
            );
        }

        CSVUploadResponseDTO response = EnseignantService.processCSVFile(file);
        return ResponseEntity.ok(response);
    }
    @GetMapping("findAll")
    public List<EnseignantResponseDTO> findAllEnseignants() {
        return EnseignantService.findAll();
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<String> deleteEnseignant(@RequestParam Long id) {
        try {
            EnseignantService.deleteById(id);
            return ResponseEntity.ok("Enseignant deleted successfully.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enseignant not found.");
        }

    }
}

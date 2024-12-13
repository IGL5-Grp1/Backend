package com.project.gestion_examens.controllers;

import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.services.impl.EnseignantService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "Access Token Authorization")
@RequiredArgsConstructor
@PreAuthorize("hasRole(T(com.project.gestion_examens.entities.Role$RoleName).DepartmentAdmin.name())")
@RestController@RequestMapping("/enseignant")
public class EnseignantController {
    @Autowired
    EnseignantService EnseignantService;

    @PostMapping("add")
    public Enseignant addEnseignant(@RequestBody Enseignant Enseignant) {
        return EnseignantService.saveEnseignant(Enseignant);
    }
    @GetMapping("findAll")
    public List<Enseignant> findAllEnseignants() {
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

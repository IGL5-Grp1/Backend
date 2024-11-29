package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.DepartementDTO;
import com.project.gestion_examens.services.impl.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@PreAuthorize("hasRole('DepartmentAdmin')")
@RestController
@RequestMapping("/departements")
public class DepartementController {

    private final DepartementService departementService;

    // Create Departement
    @PostMapping
    public ResponseEntity<DepartementDTO> createDepartement(@RequestBody DepartementDTO departementDto) {
        DepartementDTO createdDepartement = departementService.createDepartement(departementDto);
        return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
    }

    // Get Departement by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartementDTO> getDepartementById(@PathVariable Long id) {
        DepartementDTO departementDto = departementService.getDepartementById(id);
        return new ResponseEntity<>(departementDto, HttpStatus.OK);
    }

    // Get All Departements
    @GetMapping
    public ResponseEntity<List<DepartementDTO>> getAllDepartements() {
        List<DepartementDTO> departements = departementService.getAllDepartements();
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

    // Update Departement
    @PutMapping("/{id}")
    public ResponseEntity<DepartementDTO> updateDepartement(@PathVariable Long id, @RequestBody DepartementDTO departementDto) {
        DepartementDTO updatedDepartement = departementService.updateDepartement(id, departementDto);
        return new ResponseEntity<>(updatedDepartement, HttpStatus.OK);
    }

    // Delete Departement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

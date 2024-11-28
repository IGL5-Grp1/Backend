package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.DepartementDto;
import com.project.gestion_examens.services.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@RequiredArgsConstructor
public class DepartementController {

    private final DepartementService departementService;

    // Create Departement
    @PostMapping
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody DepartementDto departementDto) {
        DepartementDto createdDepartement = departementService.createDepartement(departementDto);
        return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
    }

    // Get Departement by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable Long id) {
        DepartementDto departementDto = departementService.getDepartementById(id);
        return new ResponseEntity<>(departementDto, HttpStatus.OK);
    }

    // Get All Departements
    @GetMapping
    public ResponseEntity<List<DepartementDto>> getAllDepartements() {
        List<DepartementDto> departements = departementService.getAllDepartements();
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

    // Update Departement
    @PutMapping("/{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Long id, @RequestBody DepartementDto departementDto) {
        DepartementDto updatedDepartement = departementService.updateDepartement(id, departementDto);
        return new ResponseEntity<>(updatedDepartement, HttpStatus.OK);
    }

    // Delete Departement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

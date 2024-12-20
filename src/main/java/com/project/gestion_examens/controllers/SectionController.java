package com.project.gestion_examens.controllers;

import com.project.gestion_examens.entities.Section;
import com.project.gestion_examens.services.ISectionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "Access Token Authorization")
@RequiredArgsConstructor
@PreAuthorize("hasRole(T(com.project.gestion_examens.entities.Role$RoleName).DepartmentAdmin.name())")
@RestController@RequestMapping("/section")
public class SectionController {
    ISectionService SectionService;
    @PostMapping("add")
    public Section addSection(@RequestBody Section section) {
        return SectionService.saveSection(section);
    }
    @GetMapping("findAll")
    public List<Section> getAllSections() {
        return SectionService.findAll();
    }
    @DeleteMapping("deleteById")
    public ResponseEntity<String> deleteSectionById(@RequestParam Long id) {
        try {
            SectionService.deleteSection(id);
            return ResponseEntity.ok("Section deleted successfully.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found.");
        }
    }
}

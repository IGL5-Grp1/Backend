package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaculteDto {
    private Long id;
    private String nomFaculte;
    private Long universiteId; // Reference to Universite
}

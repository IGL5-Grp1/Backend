package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleDto {
    private Long id;
    private String noSalle;
    private int capacite;
    private Long departementId; // Reference to Departement
}

package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalleDTO {
    private Long id;
    private String noSalle;
    private int capacite;
    private Long departementId; // Reference to Departement
}

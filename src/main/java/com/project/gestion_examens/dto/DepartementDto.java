package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDto {
    private Long id;
    private String nomDept;
    private Long faculteId; // Reference to Faculte
}

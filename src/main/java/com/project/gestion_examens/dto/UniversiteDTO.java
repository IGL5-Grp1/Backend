package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversiteDTO {
    private Long id;
    private String nomUniversite;
    private String region;
}

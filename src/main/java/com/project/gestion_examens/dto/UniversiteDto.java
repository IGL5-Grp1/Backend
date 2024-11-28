package com.project.gestion_examens.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversiteDto {
    private Long id;
    private String nomUniversite;
    private String region;
}

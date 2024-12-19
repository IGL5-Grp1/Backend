package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.UniversiteResponseDTO;
import com.project.gestion_examens.entities.Universite;
import org.springframework.stereotype.Component;

@Component
public class UniversiteMapper {
    public UniversiteResponseDTO toUnversiteResponseDTO(Universite universite) {
        return UniversiteResponseDTO.builder()
                .id(universite.getId())
                .nomUniversite(universite.getNomUniversite())
                .region(universite.getRegion())
                .build();
    }
}

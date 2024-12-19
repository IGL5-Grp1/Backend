package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.FaculteResponseDTO;
import com.project.gestion_examens.dto.response.UniversiteResponseDTO;
import com.project.gestion_examens.entities.Faculte;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FaculteMapper {
    UniversiteMapper universiteMapper;
    public FaculteResponseDTO toFaculteResponseDTO(Faculte faculte) {
        return FaculteResponseDTO.builder()
                .id(faculte.getId())
                .nomFaculte(faculte.getNomFaculte())
                .universite(universiteMapper.toUnversiteResponseDTO(faculte.getUniversite()))
                .build();
    }
}

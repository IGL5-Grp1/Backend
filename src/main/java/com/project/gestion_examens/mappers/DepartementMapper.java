package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.DepartementResponseDTO;
import com.project.gestion_examens.entities.Departement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DepartementMapper {
    FaculteMapper faculteMapper;
    public DepartementResponseDTO toDepartementResponseDTO(Departement departement) {
        return DepartementResponseDTO.builder()
                .id(departement.getId())
                .nomDept(departement.getNomDept())
                .faculte(faculteMapper.toFaculteResponseDTO(departement.getFaculte()))
                .build();
    }
}

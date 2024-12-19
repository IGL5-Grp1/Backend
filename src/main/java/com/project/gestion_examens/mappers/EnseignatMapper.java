package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.DepartementResponseDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.dto.response.GradeResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class EnseignatMapper {
    DepartementMapper departementMapper;
    GradeMapper gradeMapper;
    public EnseignantResponseDTO toEnseignantResponseDTO(Enseignant enseignant) {
        return EnseignantResponseDTO.builder()
                .id(enseignant.getId())
                .username(enseignant.getUsername())
                .cin(enseignant.getCin())
                .email(enseignant.getEmail())
                .departement(departementMapper.toDepartementResponseDTO(enseignant.getDepartement()))
                .grade(gradeMapper.toGradeResponseDTO(enseignant.getGrade()))
                .build();
    }

    public List<EnseignantResponseDTO> toEnseignantListResponseDTO(List<Enseignant> enseignants) {
        List<EnseignantResponseDTO> enseignantResponseDTOS = new ArrayList<>();
        for (Enseignant enseignant : enseignants) {
            enseignantResponseDTOS.add(toEnseignantResponseDTO(enseignant));
        }
        return enseignantResponseDTOS;
    }

}

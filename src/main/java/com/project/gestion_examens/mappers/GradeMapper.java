package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.GradeResponseDTO;
import com.project.gestion_examens.entities.Grade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper {
    public GradeResponseDTO toGradeResponseDTO(Grade grade) {
        return GradeResponseDTO.builder()
                .id(grade.getId())
                .nomGrade(grade.getNomGrade())
                .nbHeuresSurveillanceAFaire(grade.getNbHeuresSurveillanceAFaire())
                .nbHeuresEtudeAFaire(grade.getNbHeuresEtudeAFaire())
                .build();
    }
}

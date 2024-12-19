package com.project.gestion_examens.dto.response;

import lombok.Builder;

@Builder
public record GradeResponseDTO(Long id, String nomGrade, int nbHeuresEtudeAFaire, int nbHeuresSurveillanceAFaire) {
}

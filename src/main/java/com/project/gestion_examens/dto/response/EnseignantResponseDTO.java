package com.project.gestion_examens.dto.response;

import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Grade;
import lombok.Builder;

@Builder
public record EnseignantResponseDTO(Long id, String username, String cin, String email, DepartementResponseDTO departement, GradeResponseDTO grade) {
}

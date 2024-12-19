package com.project.gestion_examens.dto.response;

import com.project.gestion_examens.dto.FaculteDTO;
import lombok.Builder;

@Builder
public record DepartementResponseDTO(Long id, String nomDept, FaculteResponseDTO faculte) {
}

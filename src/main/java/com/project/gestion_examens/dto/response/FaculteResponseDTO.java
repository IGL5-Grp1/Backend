package com.project.gestion_examens.dto.response;

import lombok.Builder;

@Builder
public record FaculteResponseDTO(Long id, String nomFaculte, UniversiteResponseDTO universite) {
}

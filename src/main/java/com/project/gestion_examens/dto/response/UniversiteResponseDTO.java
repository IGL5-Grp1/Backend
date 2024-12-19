package com.project.gestion_examens.dto.response;

import lombok.Builder;

@Builder
public record UniversiteResponseDTO(Long id, String nomUniversite, String region) {
}

package com.project.gestion_examens.dto.response;

import lombok.Builder;

@Builder
public record EnseignantResponseDTO(Long id, String username) {
}

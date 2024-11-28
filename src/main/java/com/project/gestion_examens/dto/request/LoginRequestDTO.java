package com.project.gestion_examens.dto.request;

import lombok.Builder;

@Builder
public record LoginRequestDTO(String email, String password) {
}

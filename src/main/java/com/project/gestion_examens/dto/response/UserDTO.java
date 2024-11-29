package com.project.gestion_examens.dto.response;

import lombok.Builder;

@Builder
public record UserDTO(Long id, String email, RoleDTO role) {
}

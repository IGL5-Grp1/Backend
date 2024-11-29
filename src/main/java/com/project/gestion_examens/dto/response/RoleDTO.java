package com.project.gestion_examens.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RoleDTO(Long id, String name, List<String> subRoles) {
}

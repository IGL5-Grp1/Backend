package com.project.gestion_examens.dto.request;

import lombok.Builder;

@Builder
public record AddEnseignantDTO(String username, String email, String cin, Long departmentId, Long gradeId) {
}

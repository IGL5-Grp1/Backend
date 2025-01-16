package com.project.gestion_examens.dto.request;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReserverProfDTO(Long enseignantId, LocalDateTime startTime, LocalDateTime endTime, int dureeExamen) {}


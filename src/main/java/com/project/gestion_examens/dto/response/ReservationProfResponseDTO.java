package com.project.gestion_examens.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReservationProfResponseDTO(
        String enseignantNom,
        String cin,
        int dureeExamen,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}

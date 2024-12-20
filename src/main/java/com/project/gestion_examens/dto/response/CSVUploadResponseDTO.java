package com.project.gestion_examens.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record CSVUploadResponseDTO(int totalProcessed, int successCount, List<String> errors) {
}

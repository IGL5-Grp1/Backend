package com.project.gestion_examens.dto.response;

import com.project.gestion_examens.dto.SalleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AvailableCapacity {
    private SalleDTO salle;
    private int capacity;
}

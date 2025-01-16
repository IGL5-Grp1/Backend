package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.request.ReserverProfDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.dto.response.ReservationProfResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.services.impl.SurveillanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/surveillance")
@RequiredArgsConstructor
public class SurveillanceController {

    private final SurveillanceService surveillanceService;

    @PostMapping
    public ResponseEntity<ReservationProfResponseDTO> reserverProf(@RequestBody ReserverProfDTO reserverProfDTO) {
        ReservationProfResponseDTO response = surveillanceService.reserverProf(reserverProfDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/available-professors")
    public ResponseEntity<List<EnseignantResponseDTO>> getAvailableProfessors(
            @RequestParam Long departementId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {

        List<Enseignant> availableProfessors = surveillanceService.getAvailableProfessors(departementId, startTime, endTime);
        List<EnseignantResponseDTO> response = availableProfessors.stream()
                .map(prof -> new EnseignantResponseDTO(prof.getId(), prof.getUsername(), prof.getCin(), prof.getEmail(), null, null))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.SalleDTO;
import com.project.gestion_examens.dto.request.ReserverSalleDTO;
import com.project.gestion_examens.dto.response.AvailableCapacity;
import com.project.gestion_examens.dto.response.SalleReservationDTO;
import com.project.gestion_examens.entities.Salle;
import com.project.gestion_examens.entities.SalleReservation;
import com.project.gestion_examens.repositories.SalleRepository;
import com.project.gestion_examens.repositories.SalleReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SalleReservationService {
    SalleReservationRepository salleReservationRepository;
    SalleService salleService;
    SalleRepository salleRepository;
    public List<SalleReservationDTO> getSalleReservationList(Long salleId, LocalDateTime beginDateTime, LocalDateTime endDateTime) {
        return salleReservationRepository
                .findOverlappingReservations(salleId, beginDateTime, endDateTime)
                .stream()
                .map(SalleReservationDTO::new)
                .collect(Collectors.toList());
    }

    public List<AvailableCapacity> getSallesDisponible(LocalDateTime beginDateTime, LocalDateTime endDateTime) {
        List<SalleDTO> salles = salleService.getAllSalles();
        List<AvailableCapacity> availableCapacities = new ArrayList<>();
        for (SalleDTO salleDTO : salles) {
            List<SalleReservationDTO> salleReservationDTOS = getSalleReservationList(salleDTO.getId(), beginDateTime, endDateTime);
            int reserved = 0;
            for (SalleReservationDTO salleReservationDTO : salleReservationDTOS) {
                reserved = reserved + salleReservationDTO.getNumberOfStudents();
                if (reserved >= salleDTO.getCapacite())
                    break;
            }
            int availableCapacity = salleDTO.getCapacite() - reserved;
            if (availableCapacity > 0)
            {
                availableCapacities.add(AvailableCapacity.builder()
                        .salle(salleDTO)
                        .capacity(availableCapacity)
                        .build()
                );
            }
        }
        return availableCapacities;
    }

    public void reseverSalle(ReserverSalleDTO reserverSalleDTO) {
        Salle salle = salleRepository.findById(reserverSalleDTO.getSalleId()).orElseThrow();
        SalleReservation salleReservation = new SalleReservation();
        salleReservation.setBeginDateTime(reserverSalleDTO.getBeginDateTime());
        salleReservation.setEndDateTime(reserverSalleDTO.getEndDateTime());
        salleReservation.setNumberOfStudents(reserverSalleDTO.getNumberOfStudents());
        salleReservation.setSalle(salle);
        salleReservationRepository.save(salleReservation);
    }
}

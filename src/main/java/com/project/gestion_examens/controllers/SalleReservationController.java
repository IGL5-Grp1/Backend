package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.request.ReserverSalleDTO;
import com.project.gestion_examens.dto.response.AvailableCapacity;
import com.project.gestion_examens.dto.response.SalleReservationDTO;
import com.project.gestion_examens.services.impl.SalleReservationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("salleReservation")
@AllArgsConstructor
public class SalleReservationController {
    SalleReservationService salleReservationService;

    @GetMapping("/salleReservationList") //http://localhost:8081/api/v1/gestion-examens/salleReservation/salleReservationList?salleId=1&beginDateTime=2024-01-16T10:00:00&endDateTime=2024-01-16T15:00:00
    public List<SalleReservationDTO> getSalleReservationList(@RequestParam Long salleId, @RequestParam LocalDateTime beginDateTime, @RequestParam LocalDateTime endDateTime) {
        return salleReservationService.getSalleReservationList(salleId, beginDateTime, endDateTime);
    }

    @GetMapping("/getSallesDisponible")
    public List<AvailableCapacity> getSallesDisponible(@RequestParam LocalDateTime beginDateTime, @RequestParam LocalDateTime endDateTime) {
        return salleReservationService.getSallesDisponible(beginDateTime, endDateTime);
    }

    @PostMapping("/reserverSalle")
    public String reserverSalle(@RequestBody ReserverSalleDTO reserverSalleDTO) {
        salleReservationService.reseverSalle(reserverSalleDTO);
        return "success";
    }
}

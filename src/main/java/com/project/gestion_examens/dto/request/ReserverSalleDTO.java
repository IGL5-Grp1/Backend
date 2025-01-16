package com.project.gestion_examens.dto.request;

import com.project.gestion_examens.entities.SalleReservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserverSalleDTO {
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private int numberOfStudents;
    private Long salleId;

    // Constructor to convert from entity to DTO
    public ReserverSalleDTO(SalleReservation reservation) {
        this.beginDateTime = reservation.getBeginDateTime();
        this.endDateTime = reservation.getEndDateTime();
        this.numberOfStudents = reservation.getNumberOfStudents();
        this.salleId = reservation.getSalle().getId();
    }
}

package com.project.gestion_examens.dto.response;

import com.project.gestion_examens.entities.SalleReservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleReservationDTO {
    private Long id;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private int numberOfStudents;
    private Long salleId;

    // Constructor to convert from entity to DTO
    public SalleReservationDTO(SalleReservation reservation) {
        this.id = reservation.getId();
        this.beginDateTime = reservation.getBeginDateTime();
        this.endDateTime = reservation.getEndDateTime();
        this.numberOfStudents = reservation.getNumberOfStudents();
        this.salleId = reservation.getSalle().getId();
    }
}

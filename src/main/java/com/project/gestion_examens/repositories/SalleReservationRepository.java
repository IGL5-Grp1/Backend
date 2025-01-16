package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.SalleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SalleReservationRepository extends JpaRepository<SalleReservation, Integer> {

    @Query("""
        SELECT sr
        FROM SalleReservation sr 
        WHERE sr.salle.id = :salleId
        AND (
            (sr.beginDateTime < :endDateTime AND sr.endDateTime > :beginDateTime)
        )
    """)
    List<SalleReservation> findOverlappingReservations(
            @Param("salleId") Long salleId,
            @Param("beginDateTime") LocalDateTime beginDateTime,
            @Param("endDateTime") LocalDateTime endDateTime
    );
}

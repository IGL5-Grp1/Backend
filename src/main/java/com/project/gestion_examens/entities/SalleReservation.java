package com.project.gestion_examens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
public class SalleReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "begin_date_time")
    private LocalDateTime beginDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    @Column(name = "number_of_students")
    private int numberOfStudents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_salle")
    @JsonIgnore
    private Salle salle;
}

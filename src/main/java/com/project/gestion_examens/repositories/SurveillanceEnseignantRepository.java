package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.SurveillanceEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SurveillanceEnseignantRepository extends JpaRepository<SurveillanceEnseignant, Long> {
    List<SurveillanceEnseignant> findByEnseignantId(Long enseignantId);

    List<SurveillanceEnseignant> findByEnseignant_Departement_IdAndStartTimeBeforeAndEndTimeAfter(
            Long departementId, LocalDateTime endTime, LocalDateTime startTime);
}

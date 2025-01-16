package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.request.ReserverProfDTO;
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.dto.response.ReservationProfResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.entities.SurveillanceEnseignant;
import com.project.gestion_examens.repositories.EnseignantRepository;
import com.project.gestion_examens.repositories.SurveillanceEnseignantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveillanceService {

    private final SurveillanceEnseignantRepository surveillanceEnseignantRepository;
    private final EnseignantRepository enseignantRepository;

    public ReservationProfResponseDTO reserverProf(ReserverProfDTO reserverProfDTO) {
        Enseignant enseignant = enseignantRepository.findById(reserverProfDTO.enseignantId())
                .orElseThrow(() -> new EntityNotFoundException("Enseignant non trouvé"));

        int totalHeuresSurveillees = surveillanceEnseignantRepository.findByEnseignantId(enseignant.getId())
                .stream()
                .mapToInt(SurveillanceEnseignant::getDureeExamen)
                .sum();

        if (totalHeuresSurveillees + reserverProfDTO.dureeExamen() > enseignant.getGrade().getNbHeuresSurveillanceAFaire()) {
            throw new IllegalStateException("Nombre d'heures de surveillance dépassé");
        }

        SurveillanceEnseignant reservation = new SurveillanceEnseignant();
        reservation.setEnseignant(enseignant);
        reservation.setStartTime(reserverProfDTO.startTime());
        reservation.setEndTime(reserverProfDTO.endTime());
        reservation.setDureeExamen(reserverProfDTO.dureeExamen());

        surveillanceEnseignantRepository.save(reservation);

        return ReservationProfResponseDTO.builder()
                .enseignantNom(enseignant.getUsername())
                .cin(enseignant.getCin())
                .dureeExamen(reservation.getDureeExamen())
                .startTime(reservation.getStartTime())
                .endTime(reservation.getEndTime())
                .build();
    }

    public List<Enseignant> getAvailableProfessors(Long departementId, LocalDateTime startTime, LocalDateTime endTime) {
        List<Enseignant> enseignants = enseignantRepository.findByDepartementId(departementId);
        List<SurveillanceEnseignant> reservations = surveillanceEnseignantRepository.findByEnseignant_Departement_IdAndStartTimeBeforeAndEndTimeAfter(departementId, endTime, startTime);

        return enseignants.stream()
                .filter(enseignant -> reservations.stream().noneMatch(
                        res -> res.getEnseignant().getId().equals(enseignant.getId())
                ))
                .collect(Collectors.toList());
    }

}

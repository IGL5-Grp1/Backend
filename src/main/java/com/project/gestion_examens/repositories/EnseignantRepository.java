package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    // Find professors by CIN (Unique Identifier in Tunisia)
    Enseignant findByCin(String cin);

    // Get by username
    List<Enseignant> findByUsername(String username);

    List<Enseignant> findByEmail(String email);

    List<Enseignant> findByDepartementId(Long departmentId);
}

package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.Faculte;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Faculte entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FaculteRepository extends JpaRepository<Faculte, Long> {}
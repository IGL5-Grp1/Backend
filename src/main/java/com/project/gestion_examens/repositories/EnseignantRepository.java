package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    // Custom Query Methods using Spring Data JPA conventions

    // Find professors by CIN (Unique Identifier in Tunisia)
    Enseignant findByCin(String cin);

    // Custom Query with JPQL to retrieve professors with a specific pattern in their CIN
    @Query("SELECT p FROM Enseignant p WHERE p.cin LIKE %:pattern%")
    List<Enseignant> findByCinPattern(@Param("pattern") String pattern);

    // Get by username
    List<Enseignant> findByUsername(String username);

    List<Enseignant> findByEmail(String email);
}

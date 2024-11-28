package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}

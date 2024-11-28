package com.project.gestion_examens.repositories;


import com.project.gestion_examens.entities.Departement;
import com.project.gestion_examens.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    Section findById(long id);
    List<Section> findAllByNiveau(int niveau);
    List<Section> findAllByDepartement(Departement departement);
}
package com.project.gestion_examens.repositories;

import com.project.gestion_examens.entities.Universite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> { }

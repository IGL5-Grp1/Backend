package com.project.gestion_examens.services;

import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService implements IEnseignantService {
    @Autowired
    EnseignantRepository EnseignantRepository;

    @Override
    public Enseignant saveEnseignant(Enseignant Enseignant) {
        return EnseignantRepository.save(Enseignant);
    }

    @Override
    public List<Enseignant> findAll() {
        return EnseignantRepository.findAll();
    }

    @Override
    public Enseignant findById(Long id) {
        return EnseignantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Enseignant Enseignant = EnseignantRepository.findById(id).orElseThrow();
        EnseignantRepository.delete(Enseignant);
    }

    @Override
    public List<Enseignant> findByEmail(String email) {
        return EnseignantRepository.findByEmail(email);
    }

    @Override
    public List<Enseignant> findByUsername(String username) {
        return EnseignantRepository.findByUsername(username);
    }

    @Override
    public void update(Enseignant Enseignant) {
        Enseignant target = EnseignantRepository.findById(Enseignant.getId()).orElseThrow();
        target.setEmail(Enseignant.getEmail());
        target.setUsername(Enseignant.getUsername());
        target.setCin(Enseignant.getCin());
        EnseignantRepository.save(target);
    }
}

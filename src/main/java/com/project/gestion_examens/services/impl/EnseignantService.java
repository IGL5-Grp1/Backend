package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Enseignant;
import com.project.gestion_examens.mappers.EnseignatMapper;
import com.project.gestion_examens.repositories.EnseignantRepository;
import com.project.gestion_examens.services.IEnseignantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnseignantService implements IEnseignantService {
    EnseignantRepository EnseignantRepository;
    EnseignatMapper enseignatMapper;
    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return EnseignantRepository.save(enseignant);
    }

    @Override
    public List<EnseignantResponseDTO> findAll() {
        List<Enseignant> enseignants = EnseignantRepository.findAll();
        return enseignatMapper.toEnseignantListResponseDTO(enseignants);
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

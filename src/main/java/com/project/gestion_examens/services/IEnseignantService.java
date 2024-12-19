package com.project.gestion_examens.services;

<<<<<<< HEAD
import com.project.gestion_examens.dto.request.AddEnseignantDTO;
=======
>>>>>>> 04a9a2ff7180845565d5734b4e64bbd0e402c780
import com.project.gestion_examens.dto.response.EnseignantResponseDTO;
import com.project.gestion_examens.entities.Enseignant;

import java.util.List;

public interface IEnseignantService {
<<<<<<< HEAD
    EnseignantResponseDTO saveEnseignant(AddEnseignantDTO addEnseignantDTO);
=======
    Enseignant saveEnseignant(Enseignant Enseignant);
>>>>>>> 04a9a2ff7180845565d5734b4e64bbd0e402c780
    List<EnseignantResponseDTO> findAll();
    Enseignant findById(Long id);
    void deleteById(Long id);
    List<Enseignant> findByEmail(String email);
    List<Enseignant> findByUsername(String username);
    void update(Enseignant Enseignant);
}

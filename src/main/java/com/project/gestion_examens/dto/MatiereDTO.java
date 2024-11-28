package com.project.gestion_examens.dto;
import com.project.gestion_examens.entities.Matiere;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereDTO {

    private Long id;
    private String name;
    private float coeff;

    // Liste des IDs des SectionMatieres associées (optionnel)
    private List<Long> sectionMatiereIds;

    // Méthode pour convertir une entité en DTO
    public static MatiereDTO fromEntity(Matiere matiere) {
        if (matiere == null) {
            return null;
        }
        List<Long> sectionMatiereIds = null;
        if (matiere.getSectionMatieres() != null) {
            sectionMatiereIds = matiere.getSectionMatieres()
                    .stream()
                    .map(sectionMatiere -> sectionMatiere.getId())
                    .collect(Collectors.toList());
        }
        return new MatiereDTO(
                matiere.getId(),
                matiere.getName(),
                matiere.getCoeff(),
                sectionMatiereIds
        );
    }

    // Méthode pour convertir un DTO en entité
    public Matiere toEntity() {
        Matiere matiere = new Matiere();
        matiere.setId(this.id);
        matiere.setName(this.name);
        matiere.setCoeff(this.coeff);
        // Nous ne définissons pas sectionMatieres ici pour éviter les problèmes de dépendances circulaires
        return matiere;
    }
}

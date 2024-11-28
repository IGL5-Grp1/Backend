package com.project.gestion_examens.dto;

import com.project.gestion_examens.entities.SectionMatiere;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionMatiereDTO {

    private Long id;
    private Long sectionId;
    private Long matiereId;

    // Méthode pour convertir une entité en DTO
    public static SectionMatiereDTO fromEntity(SectionMatiere sectionMatiere) {
        if (sectionMatiere == null) {
            return null;
        }
        return new SectionMatiereDTO(
                sectionMatiere.getId(),
                sectionMatiere.getSection() != null ? sectionMatiere.getSection().getId() : null,
                sectionMatiere.getMatiere() != null ? sectionMatiere.getMatiere().getId() : null
        );
    }

    // Méthode pour convertir un DTO en entité
    public SectionMatiere toEntity() {
        SectionMatiere sectionMatiere = new SectionMatiere();
        sectionMatiere.setId(this.id);
        // Les entités Section et Matiere seront associées dans le service
        return sectionMatiere;
    }
}

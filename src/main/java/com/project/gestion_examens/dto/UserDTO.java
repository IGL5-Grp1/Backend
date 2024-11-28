package com.project.gestion_examens.dto;

import com.project.gestion_examens.entities.Enseignant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long courseId;
    private String courseName;
    private String courseDuraton;
    private String courseDescription;
    private EnseignantDTO enseignantDTO;

}

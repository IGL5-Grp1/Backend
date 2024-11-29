package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.request.CreateUserDTO;
import com.project.gestion_examens.entities.User;

public interface UserService {

    User createSuperAdmin(CreateUserDTO createUserDTO);

    User createUniversityAdmin(CreateUserDTO createUserDTO);

    User createEstablishmentAdmin(CreateUserDTO createUserDTO);

    User createDepartmentAdmin(CreateUserDTO createUserDTO);
}

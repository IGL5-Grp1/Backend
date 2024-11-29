package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.request.CreateUserDTO;
import com.project.gestion_examens.entities.Role;
import com.project.gestion_examens.entities.User;
import com.project.gestion_examens.repositories.RoleRepository;
import com.project.gestion_examens.repositories.UserRepository;
import com.project.gestion_examens.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createSuperAdmin(CreateUserDTO createUserDTO) {
        Role role =
                roleRepository.getRolesByName(Role.RoleName.SuperAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.save(User.builder()
                .email(createUserDTO.email())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .role(role)
                .build());
    }

    @Override
    public User createUniversityAdmin(CreateUserDTO createUserDTO) {
        Role role =
                roleRepository.getRolesByName(Role.RoleName.UniversityAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.save(User.builder()
                .email(createUserDTO.email())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .role(role)
                .build());
    }

    @Override
    public User createEstablishmentAdmin(CreateUserDTO createUserDTO) {
        Role role =
                roleRepository.getRolesByName(Role.RoleName.EstablishmentAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.save(User.builder()
                .email(createUserDTO.email())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .role(role)
                .build());
    }

    @Override
    public User createDepartmentAdmin(CreateUserDTO createUserDTO) {
        Role role =
                roleRepository.getRolesByName(Role.RoleName.DepartmentAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.save(User.builder()
                .email(createUserDTO.email())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .role(role)
                .build());
    }
}

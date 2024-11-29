package com.project.gestion_examens.controllers;

import com.project.gestion_examens.dto.request.CreateUserDTO;
import com.project.gestion_examens.mappers.UserMapper;
import com.project.gestion_examens.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "Access Token Authorization")
@RequiredArgsConstructor
@PreAuthorize("hasRole(T(com.project.gestion_examens.entities.Role$RoleName).SuperAdmin.name())")
@RestController
@RequestMapping("/su")
public class SuperAdminController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/createSuperAdmin")
    public ResponseEntity<?> createSuperAdmin(@RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userMapper.fromUser(userService.createSuperAdmin(createUserDTO)),
                HttpStatus.CREATED);
    }

    @PostMapping("/createUniversityAdmin")
    public ResponseEntity<?> createUniversityAdmin(@RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userMapper.fromUser(userService.createUniversityAdmin(createUserDTO)),
                HttpStatus.CREATED);
    }

    @PostMapping("/createEstablishmentAdmin")
    public ResponseEntity<?> createEstablishmentAdmin(@RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userMapper.fromUser(userService.createEstablishmentAdmin(createUserDTO)),
                HttpStatus.CREATED);
    }

    @PostMapping("/createDepartmentAdmin")
    public ResponseEntity<?> createDepartmentAdmin(@RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userMapper.fromUser(userService.createDepartmentAdmin(createUserDTO)),
                HttpStatus.CREATED);
    }
}

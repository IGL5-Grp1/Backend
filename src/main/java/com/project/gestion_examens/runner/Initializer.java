package com.project.gestion_examens.runner;

import com.project.gestion_examens.entities.Role;
import com.project.gestion_examens.entities.User;
import com.project.gestion_examens.repositories.RoleRepository;
import com.project.gestion_examens.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class Initializer implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private void createRoles() {
//        roleRepository.saveAll(Arrays.asList(
//                Role.builder().name("SuperAdmin").build(),
//                Role.builder().name("UniversityAdmin").build(),
//                Role.builder().name("EstablishmentAdmin").build(),
//                Role.builder().name("DepartmentAdmin").build()
//                )
//        );

        for (Role.RoleName roleName : Role.RoleName.values()) {
            roleRepository.save(Role.builder().name(roleName.name()).build());
        }


        Role superAdmin = roleRepository.findByName(Role.RoleName.SuperAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        Role universityAdmin = roleRepository.findByName(Role.RoleName.UniversityAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        universityAdmin.addParentRole(superAdmin);
        roleRepository.save(universityAdmin);

        Role establishmentAdmin = roleRepository.findByName(Role.RoleName.EstablishmentAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        establishmentAdmin.addParentRole(universityAdmin);
        roleRepository.save(establishmentAdmin);

        Role departmentAdmin = roleRepository.findByName(Role.RoleName.DepartmentAdmin.name()).orElseThrow(() -> new RuntimeException("Role not found"));
        departmentAdmin.addParentRole(establishmentAdmin);
        roleRepository.save(departmentAdmin);

        List<Role> roles = Arrays.asList(superAdmin, universityAdmin, establishmentAdmin, departmentAdmin);
        roles.forEach(role -> log.info("Permissions for {} are: {}", role.getName(), role.getAllPermissions()));

    }

    private void createSuperAdminUser() {
        userRepository.save(User.builder()
                .email("superadmin@domain.com")
                .password(passwordEncoder.encode("superadmin"))
                .role(roleRepository.findByName("SuperAdmin").orElseThrow(() -> new RuntimeException("Role not found")))
                .build());
    }

    @Override
    public void run(ApplicationArguments args) {
        createRoles();
        createSuperAdminUser();
    }
}

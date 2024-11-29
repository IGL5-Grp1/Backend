package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.RoleDTO;
import com.project.gestion_examens.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleMapper {

    public Role toRole(RoleDTO role) {
        return Role.builder()
                .roleId(role.id())
                .name(role.name())
                .build();
    }

    public RoleDTO fromRole(Role role) {
        return RoleDTO.builder()
                .id(role.getRoleId())
                .name(role.getName())
                .subRoles(role.getAllPermissions())
                .build();
    }
}

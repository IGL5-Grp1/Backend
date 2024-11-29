package com.project.gestion_examens.mappers;

import com.project.gestion_examens.dto.response.UserDTO;
import com.project.gestion_examens.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserMapper {

    private final RoleMapper roleMapper;

    public User toUser(UserDTO userDTO) {
        return User.builder()
                .userId(userDTO.id())
                .email(userDTO.email())
                .role(roleMapper.toRole(userDTO.role()))
                .build();
    }

    public UserDTO fromUser(User user) {
        return UserDTO.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .role(roleMapper.fromRole(user.getRole()))
                .build();
    }
}

package com.project.gestion_examens.services;

import com.project.gestion_examens.dto.request.LoginRequestDTO;
import com.project.gestion_examens.dto.response.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO);
}

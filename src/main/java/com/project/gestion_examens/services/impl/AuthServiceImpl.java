package com.project.gestion_examens.services.impl;

import com.project.gestion_examens.dto.request.LoginRequestDTO;
import com.project.gestion_examens.dto.response.LoginResponseDTO;
import com.project.gestion_examens.security.helper.JWTHelper;
import com.project.gestion_examens.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTHelper jwtHelper;
    private final UserDetailsService userDetailsService;

    @Override
    public LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO) {

        final String email = loginRequestDTO.email();
        final String password = loginRequestDTO.password();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        var user = userDetailsService.loadUserByUsername(email);
        String jwtAccessToken = jwtHelper.generateAccessToken(user.getUsername(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
        String jwtRefreshToken = jwtHelper.generateRefreshToken(user.getUsername());

        return LoginResponseDTO.builder()
                .accessToken(jwtAccessToken)
                .refreshToken(jwtRefreshToken)
                .build();
    }
}

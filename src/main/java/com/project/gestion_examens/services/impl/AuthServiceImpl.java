package com.project.gestion_examens.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.gestion_examens.dto.request.LoginRequestDTO;
import com.project.gestion_examens.dto.response.LoginResponseDTO;
import com.project.gestion_examens.entities.User;
import com.project.gestion_examens.exception.InvalidInputException;
import com.project.gestion_examens.repositories.UserRepository;
import com.project.gestion_examens.security.helper.JWTHelper;
import com.project.gestion_examens.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.project.gestion_examens.security.helper.JWTUtil.AUTH_HEADER;
import static com.project.gestion_examens.security.helper.JWTUtil.SECRET;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

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

    @Override
    public LoginResponseDTO handleRefreshToken(HttpServletRequest request) {
        String jwtRefreshToken = jwtHelper.extractTokenFromHeaderIfExists(request.getHeader(AUTH_HEADER));
        if (jwtRefreshToken != null) {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwtRefreshToken);
            String email = decodedJWT.getSubject();
            User user = userRepository.getUserByEmail(email).orElseThrow(() -> new InvalidInputException("User not found"));
            String jwtAccessToken = jwtHelper.generateAccessToken(email,
                    user.getRole().getAllPermissions().stream().map(permission -> "ROLE_" + permission).collect(Collectors.toList()));
            String newJwtRefreshToken = jwtHelper.generateRefreshToken(user.getEmail());
            return LoginResponseDTO.builder()
                    .accessToken(jwtAccessToken)
                    .refreshToken(newJwtRefreshToken)
                    .build();
        } else
            throw new InvalidInputException("Refresh token required");
    }

}

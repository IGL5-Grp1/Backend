package com.project.gestion_examens.security.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JWTHelper {

    private final Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);

    public String generateAccessToken(String email, List<String> roles) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(DateUtils.addHours(new Date(), JWTUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(JWTUtil.ISSUER)
                .withClaim("roles", roles)
                .sign(algorithm);
    }

    public String generateRefreshToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(DateUtils.addHours(new Date(), JWTUtil.EXPIRE_REFRESH_TOKEN))
                .withIssuer(JWTUtil.ISSUER)
                .sign(algorithm);
    }

    public String extractTokenFromHeaderIfExists(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(JWTUtil.BEARER_PREFIX)) {
            return authorizationHeader.substring(JWTUtil.BEARER_PREFIX.length());
        }
        return null;
    }
}

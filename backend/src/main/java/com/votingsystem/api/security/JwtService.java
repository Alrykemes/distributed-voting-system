package com.votingsystem.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.votingsystem.api.domain.user.UserPoll;
import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Setter
public class JwtService {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    private Algorithm algorithm;
    private JWTVerifier verifier;

    @PostConstruct
    public void init() {
        this.setAlgorithm(Algorithm.HMAC256(SECRET_KEY));
        this.setVerifier(JWT.require(algorithm).build());
    }

    public String generateToken(OAuth2User oAuth2User) {
        return JWT.create()
                .withSubject(oAuth2User.getAttribute("email"))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }

    public String extractEmail(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            System.out.println("token que chega no jwtservice " + token);
            System.out.println("email que ta no subject e foi extraido e vai ser retornado " + decodedJWT.getSubject());
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public boolean isTokenValid(String token) {
        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}

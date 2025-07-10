package com.votingsystem.api.security;

import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.repository.UserPollRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UserPollRepository userPollRepository;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();

        String googleId = oauthUser.getAttribute("sub");
        String name = oauthUser.getAttribute("name");
        String email = oauthUser.getAttribute("email");
        String picture = oauthUser.getAttribute("picture");

        userPollRepository.findByEmail(email).ifPresentOrElse(
                user -> {
                    user.setName(name);
                    user.setPicture(picture);
                    userPollRepository.save(user);
                },
                () -> {
                    UserPoll newUser = new UserPoll();
                    newUser.setGoogleId(googleId);
                    newUser.setName(name);
                    newUser.setEmail(email);
                    newUser.setPicture(picture);
                    userPollRepository.save(newUser);
                }
        );

        String token = jwtService.generateToken(oauthUser);

        // Colocar uma Env Aqui
        // Redireciona para o frontend com o token na query string
        String redirectUrl = "http://localhost:3000/login/success?token=" + token;

        response.sendRedirect(redirectUrl);
    }
}

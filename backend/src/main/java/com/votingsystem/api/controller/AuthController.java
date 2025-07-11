package com.votingsystem.api.controller;

import com.votingsystem.api.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/google")
    public String googleAuth() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/me")
    public ResponseEntity<User> getMe(Authentication authentication) {
            User user = (User) authentication.getPrincipal();
            return ResponseEntity.ok(user);
    }
}

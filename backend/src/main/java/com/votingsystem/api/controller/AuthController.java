package com.votingsystem.api.controller;

import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.services.UserPollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserPollService userService;

    @GetMapping("/google")
    public String googleAuth() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/me")
    public ResponseEntity<UserPoll> getMe(Authentication authentication) {
            UserPoll user = (UserPoll) authentication.getPrincipal();
            return ResponseEntity.ok(user);
    }
}

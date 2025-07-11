package com.votingsystem.api.controller;

import com.votingsystem.api.domain.user.User;
import com.votingsystem.api.domain.user.UserResponseDto;
import com.votingsystem.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @DeleteMapping()
    public ResponseEntity<UserResponseDto> deleteUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        userService.deleteUser(user);
        return ResponseEntity.ok(new UserResponseDto(user));
    }
}

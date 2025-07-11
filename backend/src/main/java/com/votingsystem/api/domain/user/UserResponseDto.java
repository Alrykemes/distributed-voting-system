package com.votingsystem.api.domain.user;

public record UserResponseDto(
        String id,
        String name,
        String email,
        String picture) {

    public UserResponseDto(User user) {
        this(user.getId(),
             user.getName(),
             user.getEmail(),
             user.getPicture()
        );
    }
}

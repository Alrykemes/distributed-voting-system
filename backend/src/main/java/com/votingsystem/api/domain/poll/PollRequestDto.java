package com.votingsystem.api.domain.poll;

public record PollRequestDto(
        String ownerId,
        String title,
        String description
) { }
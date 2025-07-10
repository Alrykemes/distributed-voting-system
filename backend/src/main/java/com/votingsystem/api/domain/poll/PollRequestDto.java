package com.votingsystem.api.domain.poll;

public record PollRequestDto(
        String title,
        String description
) { }

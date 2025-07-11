package com.votingsystem.api.domain.poll;

import com.votingsystem.api.validation.PollOptionsConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PollRequestDto(
        @NotBlank
        @Size(min = 5, max = 100)
        String title,

        @Size(max = 500)
        String description,

        @NotNull
        @Size(min = 2, max = 4)
        @PollOptionsConstraint
        List<String> options
) {}

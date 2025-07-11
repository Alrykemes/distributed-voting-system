package com.votingsystem.api.domain.poll;

import java.time.LocalDateTime;
import java.util.List;

public record PollResponseDto(
        String userId,
        String userName,
        String userPhoto,
        String id,
        String title,
        String description,
        List<PollOptionDto> options,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
    public PollResponseDto(Poll poll) {
        this(poll.getUser().getId(),
             poll.getUser().getName(),
             poll.getUser().getPicture(),
             poll.getId(),
             poll.getTitle(),
             poll.getDescription(),
             poll.getOptions().stream().map(PollOptionDto::new).toList(),
             poll.getCreatedAt(),
             poll.getUpdatedAt()
        );
    }
}

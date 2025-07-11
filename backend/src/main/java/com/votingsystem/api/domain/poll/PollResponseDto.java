package com.votingsystem.api.domain.poll;

public record PollResponseDto(
        String id,
        String title,
        String ownerId,
        String ownerName,
        String ownerPhoto,
        String description
) {
    public PollResponseDto(Poll poll) {
        this(poll.getId(),
             poll.getTitle(),
             poll.getOwner().getId(),
             poll.getOwner().getName(),
             poll.getOwner().getPicture(),
             poll.getDescription());
    }
}

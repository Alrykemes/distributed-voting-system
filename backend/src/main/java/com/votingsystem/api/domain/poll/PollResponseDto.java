package com.votingsystem.api.domain.poll;

public record PollResponseDto(
        String title,
        String ownerId,
        String ownerName,
        String ownerphoto,
        String description,
        Long positiveNumberOfVotes,
        Long negativeNumberOfVotes
) {
    public PollResponseDto(Poll poll) {
        this(poll.getTitle(), poll.getOwner().getId(), poll.getOwner().getName(), poll.getOwner().getPicture(), poll.getDescription(), poll.getPositiveNumberOfVotes(), poll.getNegativeNumberOfVotes());
    }
}

package com.votingsystem.api.domain.poll;

public record PollOptionResponseDto(
    String id,
    String text,
    long votes
) {
    public PollOptionResponseDto(PollOption pollOption) {
        this(pollOption.getId(), pollOption.getText(), pollOption.getVotes());
    }
}
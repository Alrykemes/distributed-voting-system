package com.votingsystem.api.domain.poll;

public record PollOptionDto(
    String id,
    String text,
    long votes
) {
    public PollOptionDto(PollOption pollOption) {
        this(pollOption.getId(), pollOption.getText(), pollOption.getVotes());
    }
}
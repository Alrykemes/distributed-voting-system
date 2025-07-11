package com.votingsystem.api.exception;

public class AlreadyVotedException extends RuntimeException {
    public AlreadyVotedException() {
        super("User has already voted in this poll");
    }
}

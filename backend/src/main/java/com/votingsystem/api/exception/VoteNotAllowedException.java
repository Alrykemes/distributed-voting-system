package com.votingsystem.api.exception;

public class VoteNotAllowedException extends RuntimeException {
    public VoteNotAllowedException(String message) {
        super("Vote not allowed: " + message);
    }
}

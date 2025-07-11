package com.votingsystem.api.exception;

public class InvalidPollOptionsException extends RuntimeException {
    public InvalidPollOptionsException(String message) {
        super("Invalid poll options: " + message);
    }
}

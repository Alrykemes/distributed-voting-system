package com.votingsystem.api.exception;

public class PollNotFoundException extends RuntimeException {
    public PollNotFoundException(String id) {
        super("Poll not found with ID: " + id);
    }
}


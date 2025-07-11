package com.votingsystem.api.exception;

public class InvalidJwtAuthenticationException extends RuntimeException {
    public InvalidJwtAuthenticationException(String message) {
        super("Invalid JWT token: " + message);
    }
}
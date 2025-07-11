package com.votingsystem.api.exception;

public class UnauthorizedActionException extends RuntimeException {
    public UnauthorizedActionException() {
        super("You are not authorized to perform this action");
    }
}

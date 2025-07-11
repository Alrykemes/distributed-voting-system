package com.votingsystem.api.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id) {
        super("User not found with ID: " + id);
    }
}


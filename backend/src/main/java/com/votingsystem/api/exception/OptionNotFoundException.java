package com.votingsystem.api.exception;

public class OptionNotFoundException extends RuntimeException {
    public OptionNotFoundException(String optionId) {
        super("Option not found with ID: " + optionId);
    }
}

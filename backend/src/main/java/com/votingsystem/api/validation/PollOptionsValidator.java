package com.votingsystem.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PollOptionsValidator implements ConstraintValidator<PollOptionsConstraint, List<String>> {
    @Override
    public void initialize(PollOptionsConstraint constraintAnnotation) {}

    @Override
    public boolean isValid(List<String> options, ConstraintValidatorContext context) {
        if (options == null || options.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Options list cannot be null or empty")
                    .addConstraintViolation();
            return false;
        }

        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            if (option == null || option.isBlank()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Option at index " + i + " is blank")
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}

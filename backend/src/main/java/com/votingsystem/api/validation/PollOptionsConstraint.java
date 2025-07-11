package com.votingsystem.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PollOptionsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface PollOptionsConstraint {
    String message() default "Each poll option must be non-blank";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

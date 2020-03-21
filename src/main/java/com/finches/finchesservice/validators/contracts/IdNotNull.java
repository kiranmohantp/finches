package com.finches.finchesservice.validators.contracts;

import com.finches.finchesservice.validators.IdNotNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdNotNullValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdNotNull {
    String message() default "null.id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

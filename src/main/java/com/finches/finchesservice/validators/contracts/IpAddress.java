package com.finches.finchesservice.validators.contracts;

import com.finches.finchesservice.validators.IpAddressValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IpAddressValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpAddress {
    String message() default "invalid.ip";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.finches.finchesservice.validators;

import com.finches.finchesservice.validators.contracts.IdNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IdNotNullValidator implements ConstraintValidator<IdNotNull, Object> {
    private Logger logger = LoggerFactory.getLogger(IdNotNullValidator.class);

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Object id = null;
        try {
            Method objectIdGetter
                    = object.getClass().getMethod("getId");
            id = objectIdGetter.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error("@OdNotNullValidator used in a place where object has no id field.");
        }
        return id != null;
    }
}

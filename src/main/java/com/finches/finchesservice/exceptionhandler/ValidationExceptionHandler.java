package com.finches.finchesservice.exceptionhandler;

import com.finches.finchesservice.models.response.ValidationErrorResponse;
import com.finches.finchesservice.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidationExceptionHandler {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ValidationErrorResponse> constraintViolationHandler(ConstraintViolationException exception) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        exception.getConstraintViolations().forEach(constraintViolation -> {
            String[] path = constraintViolation.getPropertyPath().toString().split("\\.");
            validationErrorResponse.getMessages()
                    .add(new StringBuilder(path[path.length - 1])
                            .append(" : ")
                            .append(Utility.getMessageFromResourceBundle(httpServletRequest, constraintViolation.getMessage())).toString());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ValidationErrorResponse> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                validationErrorResponse.getMessages()
                        .add(new StringBuilder(fieldError.getField())
                                .append(" : ")
                                .append(Utility.getMessageFromResourceBundle(httpServletRequest, fieldError.getDefaultMessage())).toString())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorResponse);
    }


}

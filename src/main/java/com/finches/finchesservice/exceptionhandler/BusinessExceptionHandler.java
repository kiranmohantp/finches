package com.finches.finchesservice.exceptionhandler;

import com.finches.finchesservice.constents.messages.MappedError;
import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.models.response.ErrorResponse;
import org.springframework.hateoas.server.core.WebHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.hateoas.server.core.WebHandler.linkTo;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity invalidCredential(InvalidCredentialsException invalidCredentialsException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getMappedErrors().add(invalidCredentialsException.getError());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(errorResponse);
    }

    @ExceptionHandler(DuplicateException.class)
    private ResponseEntity<ErrorResponse> duplicateValidation(DuplicateException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getMappedErrors().add(exception.getError());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }


}

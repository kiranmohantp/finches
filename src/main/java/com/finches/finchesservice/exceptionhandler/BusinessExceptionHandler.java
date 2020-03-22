package com.finches.finchesservice.exceptionhandler;

import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.exceptions.apiexceptions.UnableToPerformUpdateExceptions;
import com.finches.finchesservice.models.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity invalidCredential(InvalidCredentialsException invalidCredentialsException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getMappedErrors().add(invalidCredentialsException.getErrorMapping());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(errorResponse);
    }

    @ExceptionHandler(UnableToPerformUpdateExceptions.class)
    ResponseEntity invalidCredential(UnableToPerformUpdateExceptions unableToPerformUpdateExceptions) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getMappedErrors().add(unableToPerformUpdateExceptions.getError());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(errorResponse);
    }

    @ExceptionHandler(NoDataFoundException.class)
    ResponseEntity invalidCredential(NoDataFoundException noDataFoundException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getMappedErrors().add(noDataFoundException.getMappedError());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

}

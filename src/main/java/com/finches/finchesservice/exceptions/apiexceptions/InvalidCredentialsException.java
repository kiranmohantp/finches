package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.models.response.MappedError;

public class InvalidCredentialsException extends RuntimeException {
    private final MappedError errorMapping;

    public InvalidCredentialsException(MappedError error) {
        this.errorMapping = error;
    }

    public MappedError getErrorMapping() {
        return errorMapping;
    }
}

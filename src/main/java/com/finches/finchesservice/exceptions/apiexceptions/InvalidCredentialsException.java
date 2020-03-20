package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.MappedError;

public class InvalidCredentialsException extends RuntimeException {
    private final MappedError error;

    public InvalidCredentialsException(MappedError error) {
        this.error = error;
    }

    public MappedError getError() {
        return error;
    }
}

package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.ErrorMappingProvider;
import com.finches.finchesservice.constents.messages.MappedError;

public class InvalidCredentialsException extends Exception {
    private final MappedError error;

    public InvalidCredentialsException(MappedError error) {
        this.error = error;
    }

    public MappedError getError() {
        return error;
    }
}

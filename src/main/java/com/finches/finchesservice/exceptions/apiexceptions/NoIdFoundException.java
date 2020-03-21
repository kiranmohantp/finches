package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.MappedError;

public class NoIdFoundException extends RuntimeException {
    private final MappedError mappedError;

    public NoIdFoundException(MappedError mappedError) {
        this.mappedError = mappedError;
    }

    public MappedError getMappedError() {
        return mappedError;
    }
}

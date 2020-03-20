package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.MappedError;

public class NoDataFoundException extends RuntimeException {
    private final MappedError mappedError;

    public NoDataFoundException(MappedError mappedError) {
        this.mappedError = mappedError;
    }

    public MappedError getMappedError() {
        return mappedError;
    }
}

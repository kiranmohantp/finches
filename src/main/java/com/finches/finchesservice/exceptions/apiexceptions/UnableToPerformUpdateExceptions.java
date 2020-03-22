package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.models.response.MappedError;

public class UnableToPerformUpdateExceptions extends RuntimeException {
    private final MappedError error;

    public UnableToPerformUpdateExceptions(MappedError error) {
        this.error = error;
    }

    public MappedError getError() {
        return error;
    }
}

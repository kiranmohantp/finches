package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.models.response.MappedError;

public class DataIntegrityException extends RuntimeException {
    private final MappedError mappedError;

    public DataIntegrityException(MappedError mappedError) {
        this.mappedError = mappedError;
    }

    public MappedError getMappedError() {
        return mappedError;
    }
}

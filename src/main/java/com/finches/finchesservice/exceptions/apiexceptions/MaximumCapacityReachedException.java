package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.models.response.MappedError;

public class MaximumCapacityReachedException extends RuntimeException {
    private final MappedError error;

    public MaximumCapacityReachedException(MappedError error) {
        this.error = error;
    }

    public MappedError getError() {
        return error;
    }
}

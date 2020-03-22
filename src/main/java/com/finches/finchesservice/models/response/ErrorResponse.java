package com.finches.finchesservice.models.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private List<MappedError> mappedErrors;

    public ErrorResponse() {
        this.mappedErrors = new ArrayList<>(2);
    }

    public List<MappedError> getMappedErrors() {
        return mappedErrors;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "mappedErrors=" + mappedErrors +
                '}';
    }
}

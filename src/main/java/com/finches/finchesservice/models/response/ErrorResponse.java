package com.finches.finchesservice.models.response;

import com.finches.finchesservice.constents.messages.MappedError;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private List<MappedError> mappedErrors;

    public List<MappedError> getMappedErrors() {
        return mappedErrors;
    }

    public ErrorResponse() {
        this.mappedErrors = new ArrayList<>(2);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "mappedErrors=" + mappedErrors +
                '}';
    }
}

package com.finches.finchesservice.models.response;

public class MappedError {
    private String code;
    private String message;

    public MappedError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.finches.finchesservice.models.response;

import com.finches.finchesservice.constents.messages.MappedError;

import java.util.Objects;

public class GeneralErrorResponse {
    private String code;
    private String message;

    public GeneralErrorResponse(MappedError mappedError) {
        this.code = mappedError.getCode();
        this.message = mappedError.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralErrorResponse that = (GeneralErrorResponse) o;
        return Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}

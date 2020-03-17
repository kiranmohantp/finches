package com.finches.finchesservice.models.response;

import com.finches.finchesservice.constents.messages.CommonErrorMessages;

import java.util.Objects;

public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(CommonErrorMessages commonMessages) {
        this.code = commonMessages.getCode();
        this.message = commonMessages.getMessage();
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
        ErrorResponse that = (ErrorResponse) o;
        return Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}

package com.finches.finchesservice.models.response;

import com.finches.finchesservice.constents.CommonMessages;

public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(CommonMessages commonMessages) {
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
}

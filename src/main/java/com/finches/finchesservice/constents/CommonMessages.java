package com.finches.finchesservice.constents;

public enum CommonMessages {
    NO_USER_FOUND("No User Found !", "E1");

    private String message;
    private String code;

    CommonMessages(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}

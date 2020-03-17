package com.finches.finchesservice.constents.messages;

public enum CommonErrorMessages {
    INVALID_CREDENTIALS("Invalid Username Or Password !", "E1"),
    NO_DATA_FOUND("No Data Found On Db !", "E2");

    private String message;
    private String code;

    CommonErrorMessages(String message, String code) {
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

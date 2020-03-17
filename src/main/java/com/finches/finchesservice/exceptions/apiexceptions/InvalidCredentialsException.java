package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.CommonErrorMessages;

public class InvalidCredentialsException extends Exception {
    private final CommonErrorMessages commonMessages;

    public InvalidCredentialsException(CommonErrorMessages commonMessages) {
        this.commonMessages = commonMessages;
    }

    public CommonErrorMessages getCommonMessages() {
        return commonMessages;
    }
}

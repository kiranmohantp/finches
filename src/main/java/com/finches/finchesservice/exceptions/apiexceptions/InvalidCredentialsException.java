package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.CommonMessages;

public class InvalidCredentialsException extends RuntimeException {
    private CommonMessages commonMessages;

    public InvalidCredentialsException(CommonMessages commonMessages) {
        this.commonMessages = commonMessages;
    }

    public CommonMessages getCommonMessages() {
        return commonMessages;
    }
}

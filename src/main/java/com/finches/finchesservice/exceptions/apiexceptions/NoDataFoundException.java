package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.CommonErrorMessages;

public class NoDataFoundException extends Exception {
    private final CommonErrorMessages commonMessages;

    public NoDataFoundException(CommonErrorMessages commonMessages) {
        this.commonMessages = commonMessages;
    }

    public CommonErrorMessages getCommonMessages() {
        return commonMessages;
    }
}

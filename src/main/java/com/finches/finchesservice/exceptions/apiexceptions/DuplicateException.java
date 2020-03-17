package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.messages.CommonErrorMessages;

public class DuplicateException extends Exception {
    private final CommonErrorMessages commonMessages;

    public DuplicateException(CommonErrorMessages commonMessages) {
        this.commonMessages = commonMessages;
    }

    public CommonErrorMessages getCommonMessages() {
        return commonMessages;
    }
}

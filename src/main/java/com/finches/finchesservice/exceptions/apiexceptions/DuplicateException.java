package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.CommonMessages;

public class DuplicateException extends RuntimeException {
    private final CommonMessages commonMessages;

    public DuplicateException(CommonMessages commonMessages) {
        this.commonMessages = commonMessages;
    }

    public CommonMessages getCommonMessages() {
        return commonMessages;
    }
}

package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.constents.CommonMessages;

public class NoDataFoundException extends RuntimeException {
    private CommonMessages commonMessages;

    public NoDataFoundException(CommonMessages commonMessages){
        this.commonMessages = commonMessages;
    }
}

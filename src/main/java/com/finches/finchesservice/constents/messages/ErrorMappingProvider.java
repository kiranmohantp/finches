package com.finches.finchesservice.constents.messages;

import com.finches.finchesservice.utils.Utility;

import javax.servlet.http.HttpServletRequest;

public class ErrorMappingProvider {
    private static final String INVALID_CREDENTIALS = "invalid.credential";
    private static final String NO_DATA_FOUND = "no.data";

    public static MappedError INVALID_CREDENTIALS(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, INVALID_CREDENTIALS);
    }

    public static MappedError NO_DATA_FOUND(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, NO_DATA_FOUND);
    }


}

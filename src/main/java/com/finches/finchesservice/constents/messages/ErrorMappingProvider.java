package com.finches.finchesservice.constents.messages;

import com.finches.finchesservice.utils.Utility;

import javax.servlet.http.HttpServletRequest;

public class ErrorMappingProvider {
    private static final String INVALID_CREDENTIALS = "invalid.credential";
    private static final String NO_DATA_FOUND = "no.data";
    private static final String USER_ALREADY_EXISTS = "user.already.exists";
    private static final String EMAIL_ALREADY_EXISTS = "email.already.exists";

    public static MappedError INVALID_CREDENTIALS(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, INVALID_CREDENTIALS);
    }

    public static MappedError NO_DATA_FOUND(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, NO_DATA_FOUND);
    }

    public static MappedError USER_ALREADY_EXISTS(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, USER_ALREADY_EXISTS);
    }

    public static MappedError EMAIL_ALREADY_EXISTS(HttpServletRequest httpServletRequest) {
        return Utility.getErrorObject(httpServletRequest, EMAIL_ALREADY_EXISTS);
    }


}

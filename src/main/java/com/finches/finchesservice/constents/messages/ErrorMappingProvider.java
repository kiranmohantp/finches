package com.finches.finchesservice.constents.messages;

import com.finches.finchesservice.utils.MessageUtility;

import javax.servlet.http.HttpServletRequest;

public class ErrorMappingProvider {
    private static final String INVALID_CREDENTIALS = "invalid.credential";
    private static final String NO_DATA_FOUND = "no.data";
    private static final String USER_ALREADY_EXISTS = "user.already.exists";
    private static final String EMAIL_ALREADY_EXISTS = "email.already.exists";
    private static final String ID_IS_NULL = "null.id";

    public static MappedError INVALID_CREDENTIALS(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, INVALID_CREDENTIALS);
    }

    public static MappedError NO_DATA_FOUND(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, NO_DATA_FOUND);
    }

    public static MappedError USER_ALREADY_EXISTS(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, USER_ALREADY_EXISTS);
    }

    public static MappedError EMAIL_ALREADY_EXISTS(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, EMAIL_ALREADY_EXISTS);
    }
    public static MappedError ID_IS_NULL(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, ID_IS_NULL);
    }


}

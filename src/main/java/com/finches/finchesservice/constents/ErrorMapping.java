package com.finches.finchesservice.constents;

import com.finches.finchesservice.models.response.MappedError;
import com.finches.finchesservice.utils.MessageUtility;

import javax.servlet.http.HttpServletRequest;

public class ErrorMapping {
    private static final String INVALID_CREDENTIALS = "invalid.credential";
    private static final String NO_DATA_FOUND = "no.data";
    private static final String USER_ALREADY_EXISTS = "user.already.exists";
    private static final String EMAIL_ALREADY_EXISTS = "email.already.exists";
    private static final String ID_IS_NULL = "null.id";
    private static final String NAME_EXISTS = "name.alredy.exists";
    private static final String MAX_CAPACITY_REACHED = "maximum.capacity.reached";
    private static final String ID_IN_SAVE = "id.in.save";
    private static final String CAPACITY_LESS_THAN_FINCHES_ASSIGNED = "capacity.low.than.assigned.finches";
    private static final String ASSIGNED_FINCHES_NO_MISMATCH = "assigned.finches.number.mismatch";

    private ErrorMapping() {
    }

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

    public static MappedError NAME_EXISTS(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, NAME_EXISTS);
    }

    public static MappedError MAX_CAPACITY_REACHED(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, MAX_CAPACITY_REACHED);
    }

    public static MappedError ID_IN_SAVE(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, ID_IN_SAVE);
    }

    public static MappedError CAPACITY_LESS_THAN_FINCHES_ASSIGNED(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, CAPACITY_LESS_THAN_FINCHES_ASSIGNED);
    }

    public static MappedError ASSIGNED_FINCHES_NO_MISMATCH(HttpServletRequest httpServletRequest) {
        return MessageUtility.getErrorObject(httpServletRequest, ASSIGNED_FINCHES_NO_MISMATCH);
    }
}

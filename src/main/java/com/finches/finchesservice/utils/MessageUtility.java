package com.finches.finchesservice.utils;

import com.finches.finchesservice.models.response.MappedError;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtility {
    private static final String LOCALE = "locale";
    private static final String RESOURCE_BUNDLE = "i18n.ErrorMapping";

    public static Locale returnLocale(HttpServletRequest httpServletRequest) {
        Locale locale = null;
        if (StringUtils.isNotBlank(httpServletRequest.getHeader(LOCALE))) {
            locale = new Locale(httpServletRequest.getHeader(LOCALE));
        } else {
            locale = Locale.US;
        }
        return locale;
    }

    public static MappedError getErrorObject(HttpServletRequest httpServletRequest, String code) {
        return new MappedError(code, getMessageFromResourceBundle(httpServletRequest, code));
    }

    public static String getMessageFromResourceBundle(HttpServletRequest httpServletRequest, String code) {
        return ResourceBundle.getBundle(RESOURCE_BUNDLE, MessageUtility.returnLocale(httpServletRequest)).getString(code);
    }
}

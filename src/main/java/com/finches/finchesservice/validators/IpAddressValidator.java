package com.finches.finchesservice.validators;

import com.finches.finchesservice.constents.RegEx;
import com.finches.finchesservice.validators.contracts.IpAddress;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator implements ConstraintValidator<IpAddress, String> {

    @Override
    public boolean isValid(String ipAddress, ConstraintValidatorContext constraintValidatorContext) {
        Boolean valid = true;
        Matcher matcher = Pattern.compile(RegEx.IP_ADDRESS_V4).matcher(ipAddress);
        if (matcher.find() && matcher.groupCount() == 4) {
            for (int index = 1; index <= matcher.groupCount(); index++) {
                if (Integer.valueOf(matcher.group(index)) > 255) {
                    valid = false;
                }
            }
        } else {
            valid = false;
        }
        return valid;
    }
}

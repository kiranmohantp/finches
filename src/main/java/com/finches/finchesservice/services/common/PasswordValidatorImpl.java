package com.finches.finchesservice.services.common;

import com.finches.finchesservice.services.contracts.common.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidatorImpl implements PasswordValidator {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean checkPasswordsAreSame(String plainPassword, String encodedPassword) {
        return passwordEncoder.matches(plainPassword, encodedPassword);
    }
}
